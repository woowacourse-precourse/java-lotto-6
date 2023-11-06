package lotto.view;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.dto.Result;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchasedLottos.size());
        for (Lotto purchasedLotto : purchasedLottos) {
            printPurchasedLotto(purchasedLotto);
        }
    }

    private void printPurchasedLotto(Lotto purchasedLotto) {
        List<LottoNumber> numbers = purchasedLotto.getNumbers();
        List<LottoNumber> list = numbers.stream()
                .sorted()
                .toList();

        System.out.println(list);
    }

    public void printWinningResult(Result winningResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        EnumMap<Rank, Integer> rankToCount = winningResult.getRankToCount();
        BigDecimal rateOfReturn = winningResult.getRateOfReturn();

        StringBuilder sb = new StringBuilder();
        for (Entry<Rank, Integer> rankIntegerEntry : rankToCount.entrySet()) {
            int matchCount = rankIntegerEntry.getKey().getMatchCount();
            sb.append(matchCount).append("개 일치");

            boolean hasBonus = rankIntegerEntry.getKey().hasBonus();
            if (hasBonus) {
                sb.append(", 보너스 볼 일치");
            }
            long prize = rankIntegerEntry.getKey().getPrize();
            sb.append(" (").append(prize).append("원)");

            Integer value = rankIntegerEntry.getValue();
            sb.append(" - ");
            sb.append(value).append("개\n");
        }

        sb.append("총 수익률은 ").append(rateOfReturn.toPlainString()).append("%입니다.");
        System.out.println(sb);
    }
}
