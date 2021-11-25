package mainPackage;

import mainPackage.Apple;
import mainPackage.Cheese;
import mainPackage.Food;
import mainPackage.Sandwich;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        Food[] breakfast = new Food[20];

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (args[i].equals("-calories")) {
                    calculateCalories(breakfast);
                } else if (args[i].equals("-sort")) {
                    sort(breakfast);
                }
            } else {
                String[] parts = args[i].split("/");
                try {
                    Class myClass = Class.forName("mainPackage." + parts[0]);
                    if (parts.length == 1) {
                        Constructor constructor = myClass.getConstructor();
                        breakfast[i] = (Food) constructor.newInstance();
                    } else if (parts.length == 2) {
                        Constructor constructor = myClass.getConstructor(String.class);
                        breakfast[i] = (Food) constructor.newInstance(parts[1]);
                    } else if (parts.length == 3) {
                        Constructor constructor = myClass.getConstructor(String.class, String.class);
                        breakfast[i] = (Food) constructor.newInstance(parts[1], parts[2]);
                    }
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                    System.out.print(ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Введите существующий класс!");
                } catch (NoSuchMethodException ex) {
                    System.out.println("Введите правильные параметры класса!");
                }
            }
        }

        for (Food food : breakfast) {
            if (food != null) {
                food.consume();
            } else {
                break;
            }
        }
        System.out.println("Хорошего дня!");
        count(breakfast);
    }

    public static void calculateCalories(Food[] breakfast) {
        int calories = 0;
        for (Food food : breakfast) {
            if (food != null) {
                calories += food.getCalories();
            } else {
                break;
            }
        }
        System.out.println("В завтраке " + calories + " ккал");

    }

    public static void sort(Food[] breakfast){
        Arrays.sort(breakfast, new Comparator() {
            public int compare(Object o1, Object o2) {
                if(o1 == null){
                    return 1;
                }
                if (o2 == null){
                    return -1;
                }
                return ((Food) o1).getName().compareTo(((Food) o2).getName());
            }
        });
    }

    public static void count (Food[] breakfast){
        Food smallApple = new Apple("МАЛОЕ");
        int counterSmallApple = 0;
        Food bigApple = new Apple("БОЛЬШОЕ");
        int counterBigApple = 0;

        Food cheese = new Cheese();
        int counterCheese = 0;

        Food sandwichWithHamAndCheese = new Sandwich("ветчина","сыр");
        int counterSandwichHamCheese = 0;
        Food sandwichWithTomatoAndSausage = new Sandwich("помидор", "колбаса");
        int counterSandwichTomatoSausage = 0;

        for(Food food : breakfast){
            if(food!=null){
                if(food.equals(smallApple)){
                    counterSmallApple++;
                }
                if(food.equals(bigApple)){
                    counterBigApple++;
                }
                if(food.equals(cheese)){
                    counterCheese++;
                }
                if(food.equals(sandwichWithHamAndCheese)){
                    counterSandwichHamCheese++;
                }
                if(food.equals(sandwichWithTomatoAndSausage)){
                    counterSandwichTomatoSausage++;
                }
            } else{
                break;
            }
        }

        System.out.println("Ваш завтрак: ");
        System.out.println(counterSmallApple + " маленьких яблок");
        System.out.println(counterBigApple + " больших яблок");
        System.out.println(counterCheese + " сыр");
        System.out.println(counterSandwichHamCheese + " сэндвича с ветчиной и сыром");
        System.out.println(counterSandwichTomatoSausage + " сэндвича с томатом и колбасой");

    }
}
