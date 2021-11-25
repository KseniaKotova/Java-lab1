package mainPackage;
 import mainPackage.Nutritious;
 import mainPackage.Consumable;
    public abstract class Food implements Consumable, Nutritious{
        String name = null;
        private int calories = 0;
        public Food(String name){
            this.name = name;
        }

        public boolean equals(Object arg0){
            if(!(arg0 instanceof Food))
                return false;
            if(name == null || ((Food)arg0).name == null)
                return false;
            return name.equals(((Food)arg0).name) && calories ==((Food)arg0).calories;
        }

        public String toString(){
            return name;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
        public int getCalories(){
            return calories;
        }
        public void setCalories(int calories){
            this.calories = calories;
        }

    }
