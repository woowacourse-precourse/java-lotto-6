package lotto.view;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.LottoDTO;
import lotto.WinningResultDTO;
import lotto.domain.Rank;

public class OutputView {

    public void printPurchasedLottoAmount(int amount) {
        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<LottoDTO> lottoDTOs) {
        lottoDTOs.stream()
                .map(LottoDTO::getNumbers)
                .forEach(System.out::println);
    }

    public void printResult(WinningResultDTO dto) {
        Map<Rank, Integer> result = dto.getResult();
        System.out.println("당첨 통계");
        System.out.println("---");

        List<Rank> ranks = result.keySet().stream()
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .sorted(Comparator.reverseOrder())
                .toList();

        for (Rank rank : ranks) {
            if (!rank.equals(Rank.SECOND)) {
                System.out.printf("%d개 일치 (%,d원) - %d개%n", rank.getNumber(), rank.getPrize(), result.get(rank));
            }
            if (rank.equals(Rank.SECOND)) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", rank.getNumber(), rank.getPrize(), result.get(rank));
            }
        }
    }

    public void printTotalReturn(double totalReturn) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        String format = formatter.format(totalReturn);
        System.out.print("총 수익률은 " + format + "%입니다.");
    }
}