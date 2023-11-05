package lotto;

import java.text.DecimalFormat;

public enum LottoResultType {
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    FIVE_PLUS_BONUS(5, 30000000L, true),
    SIX(6, 2000000000L);

    private int correctNumber;
    private Long price;
    private int count = 0;
    private boolean useBonus = false;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    LottoResultType(int correctNumber, Long price) {
        this.correctNumber = correctNumber;
        this.price = price;
    }

    LottoResultType(int correctNumber, Long price, boolean useBonus) {
        this.correctNumber = correctNumber;
        this.price = price;
        this.useBonus = useBonus;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();

        sb.append(correctNumber).append("개 일치");

        if (useBonus) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" (");
        // 천 단위로 "," 찍는 포맷
        DecimalFormat decFormat = new DecimalFormat("###,###");
        sb.append(decFormat.format(price)).append(") - ");

        sb.append(count).append("개");
    }

}
