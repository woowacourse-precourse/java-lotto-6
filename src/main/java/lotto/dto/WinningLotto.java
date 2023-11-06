package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public record WinningLotto(Lotto lotto, LottoNumber bonus) {
}
