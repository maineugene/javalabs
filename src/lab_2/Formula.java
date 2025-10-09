package lab_2;

public class Formula {
    private int formula_ID = 1;

    public void setFormula_ID(int formula_ID){
        this.formula_ID = formula_ID;
    }
    public int getFormulaID(){
        return formula_ID;
    }
    // Формула №1 для рассчѐта
    public static Double calculate1(Double x, Double y,Double z) {
        return Math.pow(Math.pow(Math.log(1 + x),2) + Math.cos(z*z*z*Math.PI),Math.sin(y)) +1/(Math.exp(x*x) + Math.cos(Math.exp(z)) + Math.sqrt(1/y));
    }
    // Формула №2 для рассчѐта
    public static Double calculate2(Double x, Double y, Double z) {
        return y*x*x/(Math.log(Math.pow(z,y)) + Math.pow(Math.cos(Math.cbrt(x)),2));
    }
}
