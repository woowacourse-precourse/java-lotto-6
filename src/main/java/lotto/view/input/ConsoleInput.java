package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.Lotto;

public interface ConsoleInput extends InputView {
    default String readLine(){
        return Console.readLine();
    }

    default void printErrorMessage(RuntimeException e) {
        System.out.println(e.getMessage());
        System.out.println();
    }

    default void newLine() {
        System.out.println();
    }

    long requestLottoPurchaseAmount();

    Lotto requestWinningLotto();

    int requestBonusLottoNumber(Lotto winningLotto);
}
