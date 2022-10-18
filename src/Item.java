public class Item {
    private String name;
    private float price;

    public Item(String name, float price) { //конструктор
        if (price < 0) { //проверка цены на отрицательность
            price = 0;
        }
        this.name = name;
        this.price = price;
    }

    public Item() {
        this("", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void priceIncrease(float percent) { //повышение цены на определенный процент
        float n = 0, newPrice = 0;         //переменная n нужна, чтобы посчитать процент от числа
        n = (price * percent)/100;
        newPrice = n + price;
        if (newPrice < 0) { //проверка новой цены на отрицательность
            newPrice = 0;
        }
        price = newPrice;
    }

    public void priceDrop(float percent) { //уменьшение цены на определенный процент
        float n = 0, newPrice = 0;         //переменная n нужна, чтобы посчитать процент от числа
        n = (price * percent)/100;
        newPrice = price - n;
        if (newPrice < 0) { //проверка новой цены на отрицательность
            newPrice = 0;
        }
        price = newPrice;
    }
}