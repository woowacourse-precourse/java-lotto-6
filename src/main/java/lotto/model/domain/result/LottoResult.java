package lotto.model.domain.result;

import java.text.DecimalFormat;
import lotto.model.domain.Lotto;

public enum LottoResult {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private static final String COLLECTION_FORMAT = "%d개 일치";
    private static final String BONUS_FORMAT = ", 보너스 볼 일치";
    private static final String PRICE_FORMAT = " (%s원)";
    private static final DecimalFormat moneyFormat = new DecimalFormat("###,###");

    private int price;
    private int collectCount;

    LottoResult(int collectCount, int price) {
        this.collectCount = collectCount;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(COLLECTION_FORMAT, this.collectCount));
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