package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal pay = new BigDecimal(readLine().trim()); // 값 받음.
        validatePayedMoney(pay);

        // 개수
        BigDecimal count = pay.divide(BigDecimal.valueOf(1000));
        System.out.println(count + "개를 구매했습니다.");

        printLottos(count.intValue());



    }

    private static void printLottos(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto); // 숫자들을 오름차순으로 정렬
            System.out.println(lotto);
        }
    }


    private static void validatePayedMoney(BigDecimal pay) {
        if (!pay.remainder(BigDecimal.valueOf(1000)).equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위이어야 합니다.\n");
        }
    }
}
