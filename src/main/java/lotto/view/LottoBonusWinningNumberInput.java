package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoBonusWinningNumberInput {
    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputString = Console.readLine();
        return Integer.parseInt(inputString);
    }
}
