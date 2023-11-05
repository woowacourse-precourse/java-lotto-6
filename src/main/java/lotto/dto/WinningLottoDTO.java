package lotto.dto;

import lotto.domain.Lotto;

public record WinningLottoDTO(Lotto winningLottoNumbers, int bonus) {
}
