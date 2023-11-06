package lotto.module.console.input;

import java.util.List;

public interface ConsoleReader {
    int readPurchaseAmount();

    List<Integer> readWinningLottoNumbers();

    int readLottoBonusNumber();

}
