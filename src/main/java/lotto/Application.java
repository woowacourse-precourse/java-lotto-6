package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 구매를 위해 돈을 지불한다.
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal pay = new BigDecimal(readLine().trim());
        validatePayedMoney(pay);

        // 로또를 구매한다.
        BigDecimal count = pay.divide(BigDecimal.valueOf(1000));
        System.out.println(count + "개를 구매했습니다.");
        printLottos(count.intValue());

        // 당첨번호를 입력받는다.
        System.out.println("당첨 번호를 입력해 주세요");
        String[] numbers = readLine().trim().split(",");
        Lotto lotto = new Lotto(arrayToListNumbers(numbers));

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine().trim();
        Integer bonus = stringToInteger(bonusNumber);
        validateBonusNumber(bonus);


    }

    private static void validateBonusNumber(Integer bonus) {
        if (!Lotto.isLottoRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.\n");
        }
    }

    private static List<Integer> arrayToListNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Application::stringToInteger)
                .collect(Collectors.toList());
    }

    private static int stringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 로또 번호는 숫자만 입력가능합니다.\n");
        }
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
