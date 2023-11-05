package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Integer userPurchaseAmount = Integer.parseInt(Console.readLine());

        System.out.println();
        int numberOfLottos = userPurchaseAmount / 1000;
        System.out.println(numberOfLottos + "개를 구매했습니다.");

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            sortedNumbers.sort(Comparator.naturalOrder());
            System.out.println(sortedNumbers);
            purchasedLottos.add(lotto);
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요.");
        int BonusNumber = Integer.parseInt(Console.readLine());

    }
}
