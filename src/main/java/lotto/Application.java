package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        Integer userPurchaseAmount = Integer.parseInt(purchaseAmount);

        int numberOfLottos = userPurchaseAmount / 1000;
        System.out.println();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }
}
