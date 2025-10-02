package lab_1;

public abstract class Food implements Consumable {
    String name;


    public Food(String name) {
        System.out.println(this.name);
        Object a=new Object();

        this.name = name;
    }
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false;
        if (name==null || ((Food)arg0).name==null) return false;
        return name.equals(((Food)arg0).name);
    }
    public int equals(Object arg0,Object arg1){
      return 0;
    }
    public String toString() {
        return name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
