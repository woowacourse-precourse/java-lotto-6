package lotto.constants;

import static lotto.constants.LottoConstants.COMMA;
import static lotto.constants.LottoConstants.PATTERN;
import static lotto.constants.LottoConstants.REPLACE_BLANK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LottoCount {
    LOTTO_COUNT_START(3, "3개 일치 (5,000원)"),
    LOTTO_COUNT_START_FOUR(4, "4개 일치 (50,000원)"),
    LOTTO_COUNT_FIVE(5, "5개 일치 (1,500,000원)"),
    LOTTO_COUNT_BONUS(7, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    LOTTO_COUNT_SIX(6, "6개 일치 (2,000,000,000원)");

    private String priceMsg;
    private int bonusCount;
    private int count;
    private int matchesCount;
    private int multiple;

    LottoCount(int count, String priceMsg) {
        this.priceMsg = priceMsg;
        this.count = count;
        this.bonusCount = 0;
        this.matchesCount = 0;
        this.multiple = 0;
    }

    public String getPriceMsg() {
        return this.priceMsg;
    }

    public int getCount() {
        return this.count;
    }


    public int getMatChesCount() {
        return this.matchesCount;
    }

    public int getMultiple() {
        return this.multiple;
    }

    public void incrementMatchesCount() {
        matchesCount++;
    }

    public void calculateTotalPrizeAmount() {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(priceMsg);
        if (matcher.find()) {
            String matcherGroup = matcher.group(1);
            String numberFormatter = matcherGroup.replace(COMMA, REPLACE_BLANK);
            multiple += matchesCount * Integer.parseInt(numberFormatter);
        }
    }
}