package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

// 사용자로부터 값을 입력 받기 위한 ConsoleInput
public class ConsoleInput implements Input {
    // 사용자로부터 로또 구매 금액을 입력받는다.
    @Override
    public String readCost() {
        return Console.readLine();
    }

    // 사용자로부터 당첨 번호를 입력받는다.
    @Override
    public String readWinnerNumber() {
        return Console.readLine();
    }

    // 사용자로부터 보너스 번호를 입력받는다.
    @Override
    public String readBonusNumber() {
        return Console.readLine();
    }
}
