package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.common.consts.ErrorMessage;

public class LottosResult {
    private static final String WINNING_STATISTICS_INFO_MESSAGE = "당첨 통계\n---\n";
    private static final String RATE_OF_RETURN_INFO_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String HYPHEN = " - ";
    private static final String PIECE = "개";
    private static final String LINE_WRAPPING = "\n";
    private final HashMap<Winner, Integer> result = new LinkedHashMap<>();
    private BigDecimal rateOfReturn = BigDecimal.ZERO;

    public LottosResult() {
        for (Winner winner : Winner.values()) {
            result.put(winner, 0);
        }
    }

    public Integer get(Winner key) {
        validateKeyExist(key);
        return result.get(key);
    }

    public void put(Winner key, int value) {
        validateKeyExist(key);
        result.put(key, value);
    }

    public BigDecimal calculateRateOfReturn(int money) {
        if (money > 0) {
            BigDecimal totalWinningMoney = BigDecimal.valueOf(getLottoWinningMoney());
            BigDecimal investment = BigDecimal.valueOf(money);
            rateOfReturn = totalWinningMoney.divide(investment, 3, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
            return rateOfReturn;
        }
        throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
    }

    private int getLottoWinningMoney() {
        int totalMoney = 0;
        for (Map.Entry<Winner, Integer> entry : result.entrySet()) {
            totalMoney += entry.getKey().getWinningMoney() * entry.getValue();
        }
        return totalMoney;
    }

    private void validateKeyExist(Winner key) {
        if (result.get(key) == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STATISTICS_INFO_MESSAGE);
        for (Map.Entry<Winner, Integer> entry : result.entrySet()) {
            sb.append(entry.getKey().toString()).append(HYPHEN).append(entry.getValue()).append(PIECE)
                    .append(LINE_WRAPPING);
        }
        sb.append(String.format(RATE_OF_RETURN_INFO_MESSAGE, rateOfReturn.doubleValue()));
        return sb.toString();
    }
}
