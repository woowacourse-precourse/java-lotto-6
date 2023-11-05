package lotto.service;

import java.util.List;
import lotto.domain.Wallet;
import lotto.vo.Result;
import lotto.domain.WinnerNumbers;

public interface JudgeService {
    List<Result> compareLottoBundleAndWinnerNumbers(Wallet wallet, WinnerNumbers winnerNumbers);
}
