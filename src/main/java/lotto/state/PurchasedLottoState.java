package lotto.state;

import static java.util.stream.Collectors.joining;

import java.util.List;

public record PurchasedLottoState(int quantity, List<List<Integer>> purchasedLottoBundle) {

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    private static String convertLottoNumberToFormat(List<Integer> lotto) {
        return lotto.stream()
                .sorted()
                .map(String::valueOf)
                .collect(joining(DELIMITER, PREFIX, SUFFIX));
    }

    public String toResult() {
        return purchasedLottoBundle
                .stream()
                .map(PurchasedLottoState::convertLottoNumberToFormat)
                .collect(joining("\n"));
    }
    
}
