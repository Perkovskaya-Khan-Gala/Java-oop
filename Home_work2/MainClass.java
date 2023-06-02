public class MainClass {
    /*
     * Сделать так, чтобы в тарелке с едой не могло получиться отрицательного
     * количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
     * 
     * Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
     * Если коту удалось покушать (хватило еды), сытость = true. Считаем, что если
     * коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
     * наполовину сыт (это сделано для упрощения логики программы).
     *
     * Создать массив котов и тарелку с едой, попросить всех котов покушать из этой
     * тарелки и потом вывести информацию о сытости котов в консоль.
     * 
     * Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в
     * тарелку.
     */

    public static void main(String[] args) {

        Cat cat = new Cat("Barsik", 5, false);
        Plate plate = new Plate(100);
        plate.info();

        if (cat.eat(plate.getFood())) {// кормим одного кота с тарелки
            plate.setFood(plate.getFood() - cat.getAppetite());
        }

        plate.info();
        cat.info();

        Cat[] catsGroup = {
                new Cat("Mishka", 17, false),
                new Cat("Pushok", 14, false),
                new Cat("Murzik", 13, false),
                new Cat("Milka", 10, false),
                new Cat("Shustric", 20, false),
                new Cat("Amsterdam", 15, false),
                new Cat("Gosha", 10, false)
        };

        for (Cat cats : catsGroup) {// кормим котов с одной тарелки
            if (cats.eat(plate.getFood())) {
                plate.setFood(plate.getFood() - cats.getAppetite());
                plate.info();
            }
            cats.info();
        }
        plate.info();

        for (Cat cats : catsGroup) {
            int a = plate.getFood();
            if (!cats.isFull()) {
                plate.addFood(cats.getAppetite());// добавили еды ровно столько, чтобы накормить
                                                  // непоевших котов
                plate.info();
            }
            plate.setFood(plate.getFood() - a);// вычитаем излишки, которые остались от кормежки предыдущих котов
        }

        for (Cat cats : catsGroup) {// кормим голодных котов
            if (!cats.isFull()) {
                if (cats.eat(plate.getFood())) {
                    plate.setFood(plate.getFood() - cats.getAppetite());
                    cats.info();
                    plate.info();
                }
            }

        }

    }
}