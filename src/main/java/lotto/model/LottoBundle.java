package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import lotto.util.enums.LottoResult;

public class LottoBundle {
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREMENT_VALUE = 1;
    private static final char LINE = '\n';

    private final Map<Lotto, Integer> bundles;

    public LottoBundle(Map<Lotto, Integer> bundles) {
        this.bundles = bundles;
    }

    public String generateLottoTicketReport() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Lotto, Integer> entry : bundles.entrySet()) {
            Lotto lotto = entry.getKey();
            builder.append(lotto.toString()).append(LINE);
        }
        return builder.toString();
    }

    public Map<String, Integer> compareLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Map<String, Integer> winningResult = initResult();
        ResultComparator resultComparator = new ResultComparator(winningNumbers, bonusNumber);

        for (Map.Entry<Lotto, Integer> entry : bundles.entrySet()) {
            Lotto lotto = entry.getKey();
            Optional<String> point = resultComparator.result(lotto);
            updateWinningResult(point, winningResult);
        }
        return winningResult;
    }

    private Map<String, Integer> initResult() {
        Map<String, Integer> initResult = new LinkedHashMap<>();
        for (LottoResult result : LottoResult.values()) {
            initResult.put(result.getDescription(), 0);
        }
        return initResult;
    }

    private void updateWinningResult(Optional<String> point, Map<String, Integer> winningResult) {
        point.ifPresent(s ->
                winningResult.put(s, winningResult.getOrDefault(s, DEFAULT_VALUE) + INCREMENT_VALUE));
    }
}
