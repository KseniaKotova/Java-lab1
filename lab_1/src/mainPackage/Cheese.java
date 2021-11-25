package mainPackage;

public class Cheese extends Food{
    public Cheese(){
        super("Сыр");
        super.setCalories(300);
    }

    public void consume(){
        System.out.println(this + " съеден");
    }
    public void calculateCalories(){
        System.out.println(this + " было " + super.getCalories() + " ккал");
    }
}
