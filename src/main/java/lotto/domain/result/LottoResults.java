package lotto.domain.result;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoResults {
    private static final BigDecimal PERCENTAGE = new BigDecimal(100);
    private static final int FIRST_DECIMAL = 1;
    private static final String COUNT_SUFFIX = "개";
    private static final String RESULT_DELIM = "---";

    private final List<LottoResult> results;

    private LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public static LottoResults of(List<LottoResult> results) {
        return new LottoResults(results);
    }

    public int size() {
        return results.size();
    }

    public LottoResult get(int index) {
        return results.get(index);
    }

    public String toTextFormat() {
        StringBuilder sb = new StringBuilder(RESULT_DELIM).append(System.lineSeparator());
        Arrays.stream(LottoResult.values())
                .filter(LottoResult::isWinner)
                .forEach(result -> appendResultToText(sb, result));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public BigDecimal calculateProfitRate(BigDecimal payment) {
        return sum().divide(payment, FIRST_DECIMAL, RoundingMode.HALF_UP)
                .multiply(PERCENTAGE);
    }

    private void appendResultToText(StringBuilder sb, LottoResult result) {
        sb.append(result.getMessage())
                .append(sumRepetitiveLotteries(result))
                .append(COUNT_SUFFIX)
                .append(System.lineSeparator());
    }

    private int sumRepetitiveLotteries(LottoResult result) {
        return Collections.frequency(results, result);
    }

    private BigDecimal sum() {
        return Arrays.stream(LottoResult.values())
                .map(this::getResultPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private BigDecimal getResultPrice(LottoResult result) {
        int count = sumRepetitiveLotteries(result);
        return result.getTotalPrice(count);
    }
}
