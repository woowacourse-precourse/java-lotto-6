package dto;

public record LottoMoney(int money) {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public LottoMoney {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public int getAmount() {
        return money / LOTTO_TICKET_PRICE;
    }
}
