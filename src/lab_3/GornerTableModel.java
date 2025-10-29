package lab_3;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private final Double[] coefficients;
    private final Double from;
    private final Double to;
    private final Double step;

    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return (int) Math.ceil((to - from) / step) + 1;
    }

    public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step * row;
        if (col == 0) {
// Если запрашивается значение 1-го столбца, то это X
            return x;
        } else {
            Double result = coefficients[0];
            for (int i = 1; i < coefficients.length; i++) {
                result = result * x + coefficients[i];
            }
            if (col == 1) {
                return result;
            } else {
                return isCloseToInteger(result);
            }
        }
    }

    private boolean isCloseToInteger(double value) {
        double distanceFromInt = Math.abs(value - Math.round(value));
        return distanceFromInt <= 0.1;
    }

    public String getColumnName(int col) {
        return switch (col) {
            // Название 1-го столбца
            case 0 -> "Значение X";
            // Название 2-го столбца
            case 1 -> "Значение многочлена";
            // Название 3-го столбца
            case 2 -> "Близок к целому";
            default -> "";
        };
    }


    public Class<?> getColumnClass(int col) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double
        return switch(col){
            case 0, 1 -> Double.class;
            case 2 -> Boolean.class;
            default -> Object.class;
        };
    }
}
