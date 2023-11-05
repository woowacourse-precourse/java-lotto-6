package lotto.model.domain.result;

import java.text.DecimalFormat;

public enum LottoResult {

    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private static final String COLLECTION_FORMAT = "%d개 일치";
    private static final String BONUS_FORMAT = ", 보너스 볼 일치";
    private static final String PRICE_FORMAT = " (%s원)";
    private static final DecimalFormat moneyFormat = new DecimalFormat("###,###");

    private int price;

    LottoResult(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(COLLECTION_FORMAT);
        if(this.equals(SECOND)){
            sb.append(BONUS_FORMAT);
        }
        sb.append(String.format(PRICE_FORMAT, getMoneyString()));
        return sb.toString();
    }

    private String getMoneyString() {
        return moneyFormat.format(this.price);
    }
}