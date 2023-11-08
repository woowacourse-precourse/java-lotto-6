package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

    public static List<Lotto> buyLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto.sortNumbers();
            lottos.add(lotto);
        }
        return lottos;
    }

    public static void checkLottos(List<Lotto> lottos, String[] winningNumbers, int bonus) {
        for (Lotto lotto : lottos) {
            int lottoMatches = (int) Arrays.stream(winningNumbers)
                    .map(Integer::parseInt)
                    .filter(num -> lotto.getNumbers().contains(num))
                    .count();
            boolean hasBonusNumber = lotto.getNumbers().contains(bonus);

            LottoRank.getByCountAndBonus(lottoMatches, hasBonusNumber);
        }
    }

    public static void printResult(int number) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            System.out.println(rank.getPrizeInfo() + rank.getAdditionalMatches() + "개");
        }

        double totalWinnings = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalWinnings += rank.getAdditionalMatches() * rank.getPrize();
        }

        double profitRate = (totalWinnings / number) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
