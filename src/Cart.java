public class Cart {
    private int capacity; //максимальное количество
    private Item[] stack; //массив для реализации стека
    private int topIndex; //указатель на вершину стека

    public Cart(int capacity) { //при создании корзины мы должны указать максимальное количество элементов в корзине
        this.capacity = capacity;
        stack = new Item[capacity];
        topIndex = -1;
    }

    public void addItem(Item Item) { //добавление нового товара в корзину
        stack[++topIndex] = Item;
    }

    public Item deleteItem() { //удаление последнего добавленного товара в корзину
        System.out.println("Последний товар удален");
        return stack[topIndex--];
    }

    public Item readTop() { //метод, который вернет значение находящегося в позиции top
        int i = topIndex;
        topIndex = topIndex - 1;
        return stack[topIndex];
    }

    public boolean isEmpty() { //метод, проверяющий стек на пустоту
        return (topIndex == -1);
    }

    public boolean isFull() { //проверяемый метод не переполнен наш массив, в котором мы сохраняем стек
        return (topIndex == capacity - 1);
    }

    public float calculateItemPrices() { //сумма всех товаров
        float sum = 0;
        for(int i = topIndex; i >= 0; i--) {
            sum = sum + stack[i].getPrice();
        }
        return sum;
    }

    public void cartContents() {
        for(int i = topIndex; i >= 0; i--) {
            System.out.println("Товар: " + stack[i].getName() + ". Цена: " + stack[i].getPrice());
        }
    }

    public void raiseItemPrices(float percent) { //повышение цен на некоторый процент
        for(int i = topIndex; i >= 0; i--) {
            stack[i].priceIncrease(percent);
        }
        System.out.println("");
    }

    public void cutItemPrices(float percent) { //снижение цен на некоторый процент
        for(int i = topIndex; i >= 0; i--) {
            stack[i].priceDrop(percent);
        }
        System.out.println("");
    }
}