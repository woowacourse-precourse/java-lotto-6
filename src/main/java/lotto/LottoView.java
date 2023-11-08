package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class LottoView {

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
    
    public void displayLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
    
    public Lotto getWinningLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = Arrays.stream(input.split(","))
                                      .map(String::trim)
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        return new Lotto(numbers);
    }
    
    public int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
    
    public void displayResults(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    
        // Rank 열거형의 순서대로 출력
        Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.NONE) // NONE 등수는 제외
            .sorted(Comparator.comparingInt(Rank::getMatchCount)) // 오름차순 정렬
            .forEach(rank -> {
                int count = result.getMatchResults().getOrDefault(rank, 0);
                String bonusText = rank.isBonusMatch() ? ", 보너스 볼 일치" : "";
                System.out.println(rank.getMatchCount() + "개 일치" + bonusText + " (" + rank.getPrize() + "원) - " + count + "개");
            });
    
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.getProfitRate());
    }
}