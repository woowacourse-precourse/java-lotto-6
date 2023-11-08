package lotto.domain;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public enum  Prize {
    FAIL(0, "꽝 "),
    THREE_MATCH(5000, "3개 일치 "),
    FOUR_MATCH(50_000, "4개 일치 "),
    FIVE_MATCH(1_500_000, "5개 일치 "),
    FIVE_MATCH_BONUS(30_000_000, "5개 일치, 보너스 볼 일치 "),
    SIX_MATCH(2_000_000_000, "6개 일치 ");

    private int price;
    private String message;

    Prize(int price, String message) {
        this.price = price;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        this.message = message + "(" + decimalFormat.format(price) + "원)";
    }

    public static Map<Prize, Integer> initTotalPrizeMap() {
        Map<Prize, Integer> totalPrize = new LinkedHashMap<>();
        for (Prize prize : Prize.values()) {
            totalPrize.put(prize, 0);
        }
        return totalPrize;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
