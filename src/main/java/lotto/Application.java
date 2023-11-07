package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해 주세요.");
        int buyMoney = getInteger();
        int number = moneyToLottoNumber(buyMoney);
        System.out.println(number + "개를 구매했습니다");
        List<Lotto> lottoList = new ArrayList<>();
        lottoToList(number, lottoList);
        List<Integer> numbers = getNumbers();
    }

    private static void lottoToList(int number, List<Lotto> lottoList) {
        for (int i = 0; i < number; i++) {
            Lotto tmp = new Lotto(getNumbers());
            lottoList.add(tmp);
        }
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
