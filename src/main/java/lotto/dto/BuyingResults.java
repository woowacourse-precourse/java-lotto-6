package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lottos;

public record BuyingResults(List<BuyingResult> buyingResults) {

    private static final String DELIMITER = "\n";

    public static BuyingResults createFrom(final Lottos userLottos) {
        return new BuyingResults(
                userLottos.lottos()
                        .stream()
                        .map(BuyingResult::createFrom)
                        .toList()
        );
    }

    public String createResultMessage() {
        return buyingResults.stream()
                .map(BuyingResult::createSingleResultMessage)
                .collect(Collectors.joining(DELIMITER));
    }

    public int getBuyingCount() {
        return buyingResults.size();
    }
}
