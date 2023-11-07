package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public record BuyerLottoHistory(int lottoCount, List<Lotto> lottos) {
    private static final String LOTTO_COUNT_FORMAT = "개를 구매했습니다.";
    private static final String LOTTOS_DELIMITER = "\n";
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTT_NUMBERS_SUFFIX = "]";

    public String formatBuyerLottoCount() {
        return lottoCount + LOTTO_COUNT_FORMAT;
    }

    public String formatBuyerLottos() {
        return lottos.stream()
                .map(this::formatLottoNumbers)
                .collect(Collectors.joining(LOTTOS_DELIMITER));
    }

    private String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTT_NUMBERS_SUFFIX));
    }
}