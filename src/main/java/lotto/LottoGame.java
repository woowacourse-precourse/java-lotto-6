package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final InputResolver inputResolver = new InputResolver();
//    LottoGenerator lottoGenerator;
    WinningNumber winningNumber;
    public static void play() {
        inputResolver.inputLottoBuy();
    }
}
