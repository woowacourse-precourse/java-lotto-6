package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public record ComparatorRequest(WinningLotto winningLotto, List<Lotto> playerNumbers) {
}
