package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal pay = new BigDecimal(readLine().trim()); // 값 받음.
        validatePayedMoney(pay);

        Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }



    private static void validatePayedMoney(BigDecimal pay) {
        if (!pay.remainder(BigDecimal.valueOf(10)).equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위이어야 합니다.\n");
        }
    }
}
