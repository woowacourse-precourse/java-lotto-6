package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.ErrorCode.PURCHASE_AMOUNT_ERROR;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해 주세요.");
        int number = 0;
        while (number == 0) {
            try {
                number = purchase();
            } catch (RuntimeException e) {
                handleException(e);
            }
        }

        System.out.println(number + "개를 구매했습니다.");
        issueLotto(number);
    }

    private static List<Lotto> issueLotto(int number) {
        List<Lotto> lottoList = new ArrayList<>();
        while (lottoList.size() < number) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
            lotto.printNumbers();
        }
        return lottoList;
    }

    private static void handleException(RuntimeException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    private static int purchase() throws IllegalArgumentException {
        int input = Integer.parseInt(Console.readLine());
        if (input % 1000 != 0)
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR.getMessage());
        return input / 1000;
    }
}
