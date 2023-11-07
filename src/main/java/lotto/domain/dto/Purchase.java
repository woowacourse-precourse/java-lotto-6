package lotto.domain.dto;

import lotto.domain.model.Lottos;

public record Purchase(
        Integer numberOfLottos,
        Lottos lottos
) {
}
