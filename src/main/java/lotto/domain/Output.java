package lotto.domain;

import java.util.Map;
import lotto.Lotto;

import java.util.List;

public class Output {

    public void PrintInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void PrintInputWinnerNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void PrintInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void PrintLotto(List<Lotto> numbers) {
        System.out.println(numbers.size() + "개를 구매했습니다.");
        for (Lotto a : numbers) {
            System.out.println(a.getNumbers());
        }
    }

    public void PrintResult(Map<Ranking, Integer> result) {
        for (Ranking rank : result.keySet()) {
            if (rank != Ranking.MISS) {
                int count = result.get(rank);
                System.out.println(rank.getMes() + " " + count + "개");
            }
        }
    }

    public void PrintEarning(double earn){
        System.out.println("총 수익률은 " + String.format("%.1f", earn) + "%입니다.");
    }


}
