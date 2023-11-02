package lotto.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;

public record LottosDto(
        ArrayList<Lotto> lottos
) {
}
