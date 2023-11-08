package Model;

public class LottoManager {
    private final int price;
    LottoTicket lottoTicket;

    public LottoManager(int price) {
        divide(price);
        this.price = price;
        lottoTicket = new LottoTicket(price / 1000);
    }

    private void divide(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1,000으로 나누어 떨어지지 않습니다.");
        }
    }

    public int getPrice() {
        return price;
    }
}
