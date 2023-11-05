package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1,000원 단위가 아닙니다.");
        }
        int amount = money / 1000;
        System.out.println("\n"+amount+"개를 구매했습니다.");

        List<List<Integer>> lottos = new ArrayList<>();

        for (int i=0; i<amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers);
            lottos.add(numbers);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        int[] prizeNum = Stream.of(Console.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());

        System.out.println("\n당첨 통계\n---");


    }
}
