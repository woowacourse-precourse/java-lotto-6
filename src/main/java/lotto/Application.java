package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchase = Integer.parseInt(Console.readLine());
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 올바른 금액을 입력해주세요.");
        }
        System.out.println();

        int LottoTicket = purchase / 1000;
        System.out.println(LottoTicket + "개를 구매했습니다.");

        List<List<Integer>> allLotto = new ArrayList<>();
        for (int i = 0; i < LottoTicket; i++) {
            List<Integer> oneLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(oneLotto);
            System.out.print("[");
            for (int j = 0; j < oneLotto.size(); j++) {
                if (j == oneLotto.size() - 1) {
                    System.out.println(oneLotto.get(j) + "]");
                    break;
                }
                System.out.print(oneLotto.get(j) + ", ");
            }
            allLotto.add(oneLotto);
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> jackPot = new ArrayList<>();
        String[] numbers = Console.readLine().split(",");
        for (int i = 0; i < 6; i++) {
            jackPot.add(Integer.parseInt(numbers[i]));
        }
    }
}
