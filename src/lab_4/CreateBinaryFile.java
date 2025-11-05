package lab_4;
import java.io.*;

public class CreateBinaryFile {
    public static void main(String[] args) {
        String filename = "data.bin";

        try (DataOutputStream out = new DataOutputStream(
                new FileOutputStream(filename))) {

            //Синусоида
            System.out.println("Создание синусоиды...");
            for (double x = 0; x <= 2 * Math.PI; x += 0.2) {
                double y = Math.sin(x);
                out.writeDouble(x);
                out.writeDouble(y);
                System.out.println("Точка: (" + x + ", " + y + ")");
            }

            System.out.println("Файл " + filename + " создан успешно!");
            System.out.println("Размер файла: " + new File(filename).length() + " байт");

        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }
}