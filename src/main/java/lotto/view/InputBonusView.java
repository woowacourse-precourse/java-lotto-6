package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputBonusView {
    public String inputBonus() {
        printBonus();
        return Console.readLine();
    }

    public void printBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}
