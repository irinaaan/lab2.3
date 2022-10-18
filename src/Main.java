import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cart mStack = new Cart(10);
        int choice;
        float percent;
        do {
            System.out.println("1. Добавить товар\n2. Удалить последний товар\n3. Проверить полная ли корзина\n4. Проверить пустая ли корзина\n5. Сумма всех товаров\n6. Повышение цен\n7. Понижение цен\n8. Содержимое корзины\n9. Выйти из программы");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    if(mStack.isFull()) {
                        System.out.println("Корзина полная. Удалите последний товар");
                    }
                    else {
                        System.out.println("Введите название и цену товара: ");
                        Item item = new Item(in.next(), in.nextFloat());
                        mStack.addItem(item);
                    }
                    System.out.println("");
                    break;

                case 2:
                    mStack.deleteItem();
                    System.out.println("");
                    break;

                case 3:
                    System.out.println(mStack.isFull());
                    break;

                case 4:
                    System.out.println(mStack.isEmpty());
                    break;

                case 5:
                    System.out.println("Сумма всех товаров: " + mStack.calculateItemPrices());
                    System.out.println("");
                    break;

                case 6:
                    System.out.println("На сколько процентов хотите повысить цены? ");
                    percent = in.nextFloat();
                    mStack.raiseItemPrices(percent);
                    break;

                case 7:
                    System.out.println("На сколько процентов хотите понизить цены? ");
                    percent = in.nextFloat();
                    mStack.cutItemPrices(percent);
                    break;

                case 8:
                    if(mStack.isEmpty()) {
                        System.out.println("Корзина пуста");
                    }
                    else {
                        mStack.cartContents();
                    }
                    System.out.println("");
                    break;

                case 9:
                    System.out.println("Вы вышли");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Вы ввели неправильно. Попробуйте снова\n");
                    break;
            }
        } while(choice != 9);
    }
}