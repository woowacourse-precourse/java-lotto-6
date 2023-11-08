package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoConsole {

    private static final int LOTTO_PRICE = 1000;

    public static void start() {
        while (true) {
            int number = numberOfPurchases();

            if (!isFit(number, LOTTO_PRICE)) {
                System.out.println("1000원 단위로 구매할 수 있습니다.");
                continue;
            }

            System.out.println(number / 1000 + "개를 구매했습니다.");
            break;
        }
    }

    public static boolean isFit(int leftNumber, int rightNumber) {
        return leftNumber % rightNumber == 0;
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
