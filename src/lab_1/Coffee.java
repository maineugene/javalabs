package lab_1;

public class Coffee extends Food {
    private String aroma;

    public Coffee(String aroma) {
        super("Кофе");
        this.aroma = aroma;
    }

    public void consume() {
        System.out.println(this + " выпито");
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    /*public boolean equals(Object arg) {
        if (super.equals(arg)) {
            if (!(arg instanceof Coffee)) return false;
            return aroma.equals(((Coffee) arg).aroma);
        } else return false;
    }*/

    public String toString() {
        return super.toString() + " аромата '" + aroma.toUpperCase() + "'";
    }


}
