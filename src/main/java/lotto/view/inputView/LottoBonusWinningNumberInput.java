package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;

public class LottoBonusWinningNumberInput {
    public String requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}