package dto;

import java.text.MessageFormat;

public record LottoMoney(int money) {
    public static final int TICKET_PRICE = 1000;

    public LottoMoney {
        if (money % TICKET_PRICE != 0) {
            String format = MessageFormat.format("[ERROR] {0}원 단위로 입력해주세요.", TICKET_PRICE);
            throw new IllegalArgumentException(format);
        }
    }

    public int getAmount() {
        return money / TICKET_PRICE;
    }
}
