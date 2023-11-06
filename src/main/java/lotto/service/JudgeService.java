package lotto.service;

import java.util.List;
import lotto.domain.Wallet;
import lotto.vo.Result;
import lotto.domain.WinningLotto;

public interface JudgeService {
    List<Result> compareLottoBundleAndWinnerNumbers(Wallet wallet, WinningLotto winnerNumbers);
}
