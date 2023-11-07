package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoProfitResult;

public interface OutputView {

    void showLotto(LottoDto lottoDto);

    void showMessage();
    void showMessage(String message);

    void showErrorMessage(String message);

    void showResult(LottoProfitResult lottoProfitResult);
}
