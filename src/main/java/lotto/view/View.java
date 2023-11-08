package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.domain.Lotto;

public class View {

    public static String readInput(String prompt) {
        System.out.println(prompt);
        return readLine();
    }

    public static String readPayment() {
        return readInput("구입금액을 입력해 주세요.");
    }

    public static String readWinningNumbers() {
        System.out.println();
        return readInput("당첨 번호를 입력해 주세요.");
    }

    public static String readBonusNumber() {
        System.out.println();
        return readInput("보너스 번호를 입력해 주세요.");
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toSortedString());
        }
    }

    public static void printString(String target) {
        System.out.println(target);
    }
}
