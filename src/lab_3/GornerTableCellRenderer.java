package lab_3;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();
    private final JCheckBox checkBox = new JCheckBox();

    private String needle = null;
    private final DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    public GornerTableCellRenderer() {
// Показывать только 5 знаков после запятой
        formatter.setMaximumFractionDigits(5);
// Не использовать группировку (т.е. не отделять тысячи
// ни запятыми, ни пробелами), т.е. показывать число как "1000",
// а не "1 000" или "1,000"
        formatter.setGroupingUsed(false);
// Установить в качестве разделителя дробной части точку, а не
// запятую. По умолчанию, в региональных настройках
// Россия/Беларусь дробная часть отделяется запятой
        DecimalFormatSymbols dottedDouble =
                formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
// Разместить надпись внутри панели
// Установить выравнивание надписи по левому краю панели
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // Добавляем и метку и чекбокс, но показывать будем только один из них
        panel.add(label);
        // Ищем ячейки, строковое представление которых совпадает с needle
        // (иголкой). Применяется аналогия поиска иголки в стоге сена, в роли
        // стога сена - таблица
        panel.add(checkBox);
    }

    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        label.setVisible(false);
        checkBox.setVisible(false);

        if (col == 2){
            checkBox.setSelected((Boolean)value);
            checkBox.setVisible(true);
            checkBox.setEnabled(false);
            panel.setBackground(isSelected ? table.getSelectionBackground() : Color.WHITE);
        } else {
            String formattedDouble = formatter.format(value);
            label.setText(formattedDouble);
            label.setVisible(true);
// Преобразовать double в строку с помощью форматировщика
// Установить текст надписи равным строковому представлению числа
// Номер столбца = 1 (т.е. второй столбец) + иголка не null
// (значит что-то ищем) +
// значение иголки совпадает со значением ячейки таблицы -
// окрасить задний фон панели в красный цвет
// Иначе - в обычный белый
            if (col == 1 && needle != null && needle.equals(formattedDouble)) {
                panel.setBackground(Color.RED);
            } else {
                panel.setBackground(isSelected ? table.getSelectionBackground() : Color.WHITE);
            }
        }
        return panel;
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }
}


