package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public static String readInput(String prompt) {
        System.out.println(prompt);
        return readLine();
    }

    public static String readPayment() {
        return readInput("구입금액을 입력해 주세요.");
    }

    public static String readWinningNumbers() {
        return readInput("당첨 번호를 입력해 주세요.");
    }

    public static String readBonusNumber() {
        return readInput("보너스 번호를 입력해 주세요.");
    }
}
