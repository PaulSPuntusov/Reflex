import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException{
        Cat cat = new Cat("Vasya",10, new ArrayList<>(Arrays.asList("Anton","Oleg","Igor")));
        Class catClass = cat.getClass();
        System.out.println("до Терминатора "+Arrays.toString(catClass.getDeclaredFields()));
        classFieldTerminator(cat);
        System.out.println("После Терминатора "+cat);

    }
    public static void classFieldTerminator(Object object) throws IllegalAccessException {
        for(Field declaredField : object.getClass().getDeclaredFields()){
            declaredField.setAccessible(true);
            if(!declaredField.getType().isPrimitive()){
                declaredField.set(object,null);
            }
        }
    }

}