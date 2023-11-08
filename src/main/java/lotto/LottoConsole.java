package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoConsole {

    public static void start() {
        int number = numberOfPurchases();

        System.out.println(number + "를 구매했습니다.");
    }

    public static int numberOfPurchases() {
        System.out.println("구입금액을 입력해 주세요.");
        int number;
        try {
            number = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
        }
        return number;
    }

    public static Lotto buy() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
