package lotto.LottoView;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class LottoView {
    public int inputMoney() {
        System.out.println();
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(Console.readLine());
    }

    public void showLottos(int countLotto, List<List<Integer>> lottos) {
        System.out.println();
        System.out.println(countLotto + "개를 구매했습니다.");

        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public String winNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");

        return Console.readLine();
    }

    public int bonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");

        return Integer.parseInt(Console.readLine());
    }

    public void showResult(Map<String, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계\n---");

        result.forEach((rank, count) ->
                System.out.println(rank + " - " + count + "개")
        );
    }

    public void showRate(String yieldRate) {
        System.out.println("총 수익률은 " + yieldRate + "입니다.");
    }

    public void errorMeg(String meg) {
        System.out.println("[ERROR] " + meg);
    }

}