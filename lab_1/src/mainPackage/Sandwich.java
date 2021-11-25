package mainPackage;

public class Sandwich extends Food {
    private String filling1;
    private String filling2;

    public Sandwich(String filling1, String filling2) {
        super("Бутерброд");
        this.filling1 = filling1;
        this.filling2 = filling2;

        if (filling1.equals("ветчина") || filling2.equals("ветчина")) {
            super.setCalories(super.getCalories() + 230);
        }
        if (filling1.equals("сыр") || filling2.equals("сыр")) {
            super.setCalories(super.getCalories() + 100);
        }
        if (filling1.equals("помидор") || filling2.equals("помидор")) {
            super.setCalories(super.getCalories() + 60);
        }
        if (filling1.equals("колбаса") || filling2.equals("колбаса")) {
            super.setCalories(super.getCalories() + 260);
        }
    }

    @Override
    public void consume() {
        System.out.println(this + " съеден");
    }

    public void calculateCalories() {
        System.out.println(this + " было " + super.getCalories() + " ккал");
    }

    public String getFilling1() {
        return filling1;
    }

    public void setFilling1(String filling1) {
        this.filling1 = filling1;
    }

    public String getFilling2() {
        return filling2;
    }

    public void setFilling2(String filling2) {
        this.filling2 = filling2;
    }

    public String toString() {
        return super.toString() + " с " + filling1.toUpperCase() + " и " + filling2.toUpperCase();
    }

    public boolean equals(Object obj){
        if(super.equals(obj)){
            if(!(obj instanceof Sandwich)){
                return false;
            }
            return filling1.equals(((Sandwich)obj).filling1) && filling2.equals(((Sandwich)obj).filling2) ||
                    filling1.equals(((Sandwich)obj).filling2) && filling2.equals(((Sandwich)obj).filling1);
        } else{
            return false;
        }
    }
}
