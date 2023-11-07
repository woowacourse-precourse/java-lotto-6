package lotto.domain.dto.input;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public record DrawLottoDto(Lotto winningNumbers, LottoNumber bonusNumber) {
}
