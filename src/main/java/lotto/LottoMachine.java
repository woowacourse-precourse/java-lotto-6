package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.RandomUtils;

public class LottoMachine {
    final int lottoPrice = 1000;
    public List<Lotto> buyLottos() {
        var inputPrice = Integer.parseInt(Console.readLine());
        var lottoCount = inputPrice / lottoPrice;

        var lottos = IntStream.rangeClosed(1, lottoCount)
                .mapToObj((i) -> new Lotto(RandomUtils.createSortedUniqueRandomListOf(1, 45, 6)))
                .collect(Collectors.toList());
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
        for (var lotto : lottos) {
            System.out.println(lotto.toString());
        }
        return lottos;
    }

    public List<Integer> inputWinnings() {
        System.out.println("당첨 번호를 입력해 주세요.");
        var winnings = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return winnings;
    }

    public Integer inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        var bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }

    public void goLotto(List<Lotto> lottos) {
        var winnings = inputWinnings();
        var bonus = inputBonus();

        System.out.println("당첨 통계");
        System.out.println("---");

        long match3 = 0, match4 = 0, match5 = 0 , match5Bonus = 0 , match6 = 0;

        match3 = lottos.stream().filter(lotto -> lotto.matchCount(winnings) == 3).count();
        System.out.println("3개 일치 (5,000원) - " + match3 +"개");
        match4 = lottos.stream().filter(lotto -> lotto.matchCount(winnings) == 4).count();
        System.out.println("4개 일치 (50,000원) - " + match4 +"개");
        match4 = lottos.stream().filter(lotto -> lotto.matchCount(winnings) == 5 && !lotto.matchBonus(bonus)).count();
        System.out.println("5개 일치 (1,500,000원) - " + match5 +"개");
        match5Bonus = lottos.stream().filter(lotto -> lotto.matchCount(winnings) == 5 && lotto.matchBonus(bonus)).count();
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + match5 +"개");
        match6 = lottos.stream().filter(lotto -> lotto.matchCount(winnings) == 6).count();
        System.out.println("6개 일치 (2,000,000,000원) - " + match6 +"개");


        var profit = 5000L * match3 +
                50000L * match4 +
                1500000L * match5 +
                30000000L * match5Bonus +
                2000000000L * match6;

        var profitRate = ((double)profit / (lottoPrice * lottos.size())) * 100;
        System.out.println(String.format("총 수익률은 %.1f%%입니다", profitRate));
    }
}
