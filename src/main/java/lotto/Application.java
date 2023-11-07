package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int number = 0;
        try {
            number = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]");
        }
        System.out.println();

        System.out.println(number/1000+"개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<number/1000 ; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers);
            lottos.add(new Lotto(numbers));
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumbers = Console.readLine().split(",");
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonus = Integer.parseInt(Console.readLine());
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");

        for(Lotto lotto : lottos) {
            int lottoMatches = 0;
            for (String select : winningNumbers) {
                if (lotto.getNumbers().contains(Integer.parseInt(select))) {
                    lottoMatches++;
                }
            }
            boolean hasBonusNumber = lotto.getNumbers().contains(bonus);
        }
    }
}