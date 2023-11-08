package Model;

public class LottoManager {
    private int price;

    public LottoManager(int price) {
        divide(price);
        this.price = price;
    }

    private void divide(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1,000으로 나누어 떨어지지 않습니다.");
        }
    }
}
