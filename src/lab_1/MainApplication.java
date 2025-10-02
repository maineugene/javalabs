package lab_1;

public class MainApplication {


    static char a;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Cheese obj =new Cheese();

        System.out.println(a);
        System.out.println(obj.name);
        Consumable[] breakfast = new Consumable[20];

        int itemsSoFar = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            switch (parts[0]) {
                case "Сыр" ->
// У сыра дополнительных параметров нет
                        breakfast[itemsSoFar] = new Cheese();
                case "Яблоко" ->
// У яблока – 1 параметр, который находится в parts[1]
                        breakfast[itemsSoFar] = new Apple(parts[1]);
                case "Кофе" -> breakfast[itemsSoFar] = new Coffee(parts[1]);
            }
            itemsSoFar++;
        }
// Перебор всех элементов массива
        for (Consumable item : breakfast){
            if (item != null)
// Если элемент не null – употребить продукт
                item.consume();
            else
                break;}
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

    public static int countFood(Consumable[] breakfast, Consumable target) {
        int count = 0;
        for (Consumable item : breakfast) {
            if (item != null && item.equals(target)) {
                count++;
            }
        }
        return count;
    }
}




