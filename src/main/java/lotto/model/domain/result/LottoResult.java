package lotto.model.domain.result;

import java.text.DecimalFormat;
import lotto.constance.PrintConst;

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
    private static final DecimalFormat moneyFormat = new DecimalFormat(PrintConst.DECIMAL_FORMAT_MONEY);

    private int prize;
    private int collectCount;

    LottoResult(int collectCount, int prize) {
        this.collectCount = collectCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(COLLECTION_FORMAT, this.collectCount));
        if (this.equals(SECOND)) {
            sb.append(BONUS_FORMAT);
        }
        sb.append(String.format(PRICE_FORMAT, getMoneyString()));
        return sb.toString();
    }

    private String getMoneyString() {
        return moneyFormat.format(this.prize);
    }
}