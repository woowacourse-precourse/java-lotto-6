package lotto.domain.dto.input;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public record WinningLottoRequest(Lotto winningNumbers, LottoNumber bonusNumber) {
}
