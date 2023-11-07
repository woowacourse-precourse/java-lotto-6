package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해 주세요.");
        int buyMoney = getInteger();
        int number = moneyToLottoNumber(buyMoney);
        List<Integer> numbers = getNumbers();
    }

    private static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static String getString() {
        return Console.readLine();
    }

    private static int getInteger() {
        return Integer.parseInt(Console.readLine());
    }

    private static int moneyToLottoNumber(int buyMoney) {
        return buyMoney / 1000;
    }
}
