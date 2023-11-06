package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoResults {
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
        StringBuilder sb = new StringBuilder("---").append(System.lineSeparator());
        Arrays.stream(LottoResult.values())
                .filter(LottoResult::isWinner)
                .forEach(result -> appendResultToText(sb, result));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public BigDecimal calculateProfitRate(BigDecimal payment) {
        return sum().divide(payment, 1, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100));
    }

    private void appendResultToText(StringBuilder sb, LottoResult result) {
        sb.append(result.getMessage())
                .append(sumRepetitiveLotteries(result))
                .append("개")
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
