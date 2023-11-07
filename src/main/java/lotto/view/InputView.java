package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public static String readWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public static String readBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLine();
    }
}
