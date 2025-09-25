package lab_1;

public class MainApplication {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];

        int itemsSoFar = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Сыр")) {
// У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
            } else if (parts[0].equals("Яблоко")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
            } else if (parts[0].equals("Кофе")) {
                breakfast[itemsSoFar] = new Coffee(parts[1]);
            }
// ... Продолжается анализ других продуктов для завтрака
            itemsSoFar++;
        }
// Перебор всех элементов массива
        for (Food item : breakfast)
            if (item != null)
// Если элемент не null – употребить продукт
                item.consume();
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
        System.out.println("Всего хорошего!");
        // Подсчёт продуктов по типу
        Food targetApple = new Apple("любое");
        Food targetCheese = new Cheese();
        Food targetCoffee = new Coffee("любой");

        int appleCount = countFood(breakfast, targetApple);
        int cheeseCount = countFood(breakfast, targetCheese);
        int coffeeCount = countFood(breakfast, targetCoffee);

        System.out.println("Яблок: " + appleCount);
        System.out.println("Сыров: " + cheeseCount);
        System.out.println("Кофе: " + coffeeCount);

        System.out.println("Всего хорошего!");
    }

    public static int countFood(Food[] breakfast, Food target) {
        int count = 0;
        for (Food item : breakfast) {
            if (item != null && item.equals(target)) {
                count++;
            }
        }
        return count;
    }
}




