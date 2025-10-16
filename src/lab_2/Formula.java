package lab_2;

public class Formula {
    //private int formula_ID = 1;
    private double sum = 0.0;

    /*public void setFormula_ID(int formula_ID){
        this.formula_ID = formula_ID;
    }*/
   /* public int getFormulaID(){
        return formula_ID;
    }*/
    public void summariseResult(double result){
        sum +=  result;
    }
    public  double getSum(){
        return sum;
    }
    public void cleanSum(){
        sum = 0.0;
    }
    // Формула №1 для рассчѐта
    public static Double calculate1(double x, double y,double z) {
        return Math.pow(Math.pow(Math.log(1 + x),2) + Math.cos(z*z*z*Math.PI),Math.sin(y)) +1/(Math.exp(x*x) + Math.cos(Math.exp(z)) + Math.sqrt(1/y));
    }
    // Формула №2 для рассчѐта
    public static Double calculate2(double x, double y, double z) {
        return y*x*x/(Math.log(Math.pow(z,y)) + Math.pow(Math.cos(Math.cbrt(x)),2));
    }
}
