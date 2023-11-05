package lotto.domain.dto;

import lotto.domain.Lottos;

public record PurchaseDTO(
        Integer numberOfLottos,
        Lottos lottos
) {
}
