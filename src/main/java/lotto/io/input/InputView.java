package lotto.io.input;

import java.util.List;

public interface InputView {

    String getLottoMoney();

    List<String> getWinningNumbers();

    String getBonusNumber();
}
