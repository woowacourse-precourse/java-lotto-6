package lotto.domain.dto;

import lotto.domain.Lottos;

public record Purchase(
        Integer numberOfLottos,
        Lottos lottos
) {
}
