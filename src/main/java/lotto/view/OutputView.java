package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public interface OutputView {

    void writeLottoPurchaseMoney();

    void writeGeneratedLotto(List<Lotto> lottos);

    void writeLottoWinningNumbers();

    void writeLottoBonusNumber();

    void writeResult();

    void writeBlank();

    void writeWithErrorMessage(String message);
}
