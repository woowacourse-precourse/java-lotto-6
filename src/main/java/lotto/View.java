package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public static String[] readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        return readLine().split(",");
    }
}
