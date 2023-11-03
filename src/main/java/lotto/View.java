package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class View {

    public static int readPayment() {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                return StringUtils.stringToNumber(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                return StringUtils.stringToNumbers(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
