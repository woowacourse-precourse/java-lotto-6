package lotto;

public class Money {

    private static int price;
    private final int priceUnit = 1_000;

    public Money (){
        price = 0;
    }

    public Money(int price) {
        vaildateNegativeRange(price);
        vaildateLowRange(price);
        vaildateRemain(price);
        this.price = price;
    }

    private void vaildateNegativeRange(int price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void vaildateLowRange(int price) {
        if (0 <= price && price < priceUnit) {
            throw new IllegalArgumentException("[ERROR] 최소 금액은 1000원입니다");
        }
    }

    private void vaildateRemain(int price) {
        if (price % priceUnit != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주시길 바랍니다");
        }
    }

    public int calculateLottoSize() {
        return price / priceUnit;
    }

    public int getPrice(){
        return price;
    }
}
