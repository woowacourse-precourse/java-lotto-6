package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Yield;
import lotto.dto.WinningResult;

import java.util.List;

public interface OutputView {

    void writeLottoPurchaseMoney();

    void writeGeneratedLotto(List<Lotto> lottos);

    void writeLottoWinningNumbers();

    void writeLottoBonusNumber();

    void writeResult(WinningResult winningResult, Yield yield);

    void writeBlank();

    void writeWithErrorMessage(String message);
}
