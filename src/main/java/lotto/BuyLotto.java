package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    public int buy() {
        System.out.println("구입 금액을 입력 해 주세요.");
        String m = Console.readLine();
        int lottoCount = 0;
        try {
            exceptionHandling(m);
            lottoCount = Integer.parseInt(m) / 1000;
            System.out.println();
            System.out.printf("%d개를 구매 했습니다.", lottoCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buy();
        }
        return lottoCount;
    }

    public void exceptionHandling(String money) {
        if (!money.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        int buy = Integer.parseInt(money);
        if (buy % 1000 != 0 || buy < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 할 수 있습니다.");
        }
    }

    public Lotto generateLotto() {
        List<Integer> balls = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(balls);
        return new Lotto(balls);
    }

}
