package lotto;

import static lotto.Constant.ALL_CORRECT;
import static lotto.Constant.FIFTH;
import static lotto.Constant.FIRST;
import static lotto.Constant.FORTH;
import static lotto.Constant.LONG_ZERO;
import static lotto.Constant.PERCENTAGE;
import static lotto.Constant.SECOND;
import static lotto.Constant.THIRD;
import static lotto.Constant.THOUSAND;
import static lotto.Constant.ZERO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final Map<Integer, Long> gainStatics;
    private final Map<Integer, List<Integer>> reception;
    private final List<Integer> numbers;
    private final int count;
    private final int luckyNumber;

    public Board(LottoDispatcher lottoDispatcher) {
        this.count = lottoDispatcher.getLottoTable().getRow();
        this.numbers = lottoDispatcher.getLotto().getNumbers();
        this.reception = lottoDispatcher.getLottoTable().getLottoTable();
        this.luckyNumber = lottoDispatcher.getLuckNumber();
        this.gainStatics = generateStatics();
        collectingProfit();
    }

    private Map<Integer, Long> generateStatics() {
        Map<Integer, Long> initStatics = new HashMap<>();
        for (int i = FIRST; i < ALL_CORRECT; i++) {
            initStatics.put(i, LONG_ZERO);
        }
        return initStatics;
    }

    public Map<Integer, Long> getGainStatics() {
        return gainStatics;
    }

    public String getCalculatedProfit() {
        long profit = LONG_ZERO;
        for (int i = FIRST; i < ALL_CORRECT; i++) {
            profit += multiplePrice(gainStatics.get(i), Price.getByKey(i).getValue());
        }
        int principal = THOUSAND * count;
        double profitRate = ((double) profit / principal) * PERCENTAGE;
        BigDecimal roundedProfitRate = BigDecimal.valueOf(profitRate).setScale(SECOND, RoundingMode.HALF_UP);
        return String.format("%.1f", roundedProfitRate);
    }

    private void collectingProfit() {
        for (int i = ZERO; i < reception.size(); i++) {
            boolean isBonus = reception.get(i).contains(luckyNumber);
            staticsCalculating(getMatchCount(i), isBonus);
        }
    }

    private static long multiplePrice(long multi, String priceString) {
        try {
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            Number number = numberFormat.parse(priceString);
            return multi * number.longValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void staticsCalculating(long matchCount, boolean isBonus) {
        matchWithBonus(matchCount, isBonus, ZERO);
    }

    private void matchWithBonus(long matchCount, boolean isBonus, int index) {
        if (matchCount == FIFTH) {
            index = transFifthPointWithBonus(matchCount, isBonus);
            increaseStatics(index);
        }
        if (THIRD <= matchCount && matchCount <= ALL_CORRECT) {
            index = transAnotherPoint(matchCount);
            increaseStatics(index);
        }
        if (index == ALL_CORRECT) {
            throw new IllegalStateException("[ERROR] 번호 일치 파라미터 문제");
        }
    }

    private void increaseStatics(int index) {
        long amount = gainStatics.get(index);
        gainStatics.put(index, ++amount);
    }

    private long getMatchCount(int i) {
        if (reception.get(i) != null) {
            return reception.get(i).stream().filter(numbers::contains).count();
        }
        return ZERO;
    }

    private Integer transAnotherPoint(long matchCount) {

        if (matchCount == ALL_CORRECT) {
            return FIFTH;
        }
        if (matchCount == FORTH) {
            return SECOND;
        }
        if (matchCount == THIRD) {
            return FIRST;
        }
        return ALL_CORRECT;
    }

    private Integer transFifthPointWithBonus(long matchCount, boolean isBonus) {
        if (matchCount == FIFTH && isBonus) {
            return FORTH;
        }
        return THIRD;
    }
}