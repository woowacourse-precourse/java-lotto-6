package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static int getPurchaseAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
