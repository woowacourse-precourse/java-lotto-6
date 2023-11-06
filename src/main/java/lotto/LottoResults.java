package lotto;

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
        return sb.toString();
    }

    private void appendResultToText(StringBuilder sb, LottoResult result) {
        sb.append(result.getMessage())
                .append(Collections.frequency(results, result))
                .append("개")
                .append(System.lineSeparator());
    }
}
