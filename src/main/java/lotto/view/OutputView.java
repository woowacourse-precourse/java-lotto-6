package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.utils.enums.LottoCount;

public class OutputView {
    private final String OUTPUT_FORMAT = "당첨 통계";
    private final String OUTPUT_LINE = "---";

    public void outputCreatedLottos(List<List<Integer>> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            List<Integer> sortedLotto = lotto.stream().sorted().collect(Collectors.toList());
            System.out.println(sortedLotto);
        }
    }

    public void outputWinningResult(Map<LottoCount, Integer> resultTable) {
        System.out.println("\n" + OUTPUT_FORMAT);
        System.out.println(OUTPUT_LINE);

        List<LottoCount> lottoCounts = new ArrayList<>(resultTable.keySet());
        lottoCounts.sort(Comparator.comparingLong(LottoCount::getPrice));

        for (LottoCount lottoCount : lottoCounts) {
            if (lottoCount.equals(LottoCount.NONE)) {
                continue;
            }
            String content = lottoCount.getContent();
            String price = lottoCount.getPriceCommaFormat();
            Integer duplicatedNumber = resultTable.get(lottoCount);
            System.out.println(content + " (" + price + ")" + " - " + duplicatedNumber + "개");
        }
    }

    public void outputWinningRate(long winningTotalPrice, int inputPrice) {
        double winningRate = (double) winningTotalPrice / inputPrice;
        DecimalFormat decimalFormat = new DecimalFormat("#,###,###.0%");
        String rateFormat = decimalFormat.format(winningRate);
        if (rateFormat.equals(".0%")) {
            rateFormat = "0.0%";
        }
        System.out.printf("총 수익률은 %s입니다.", rateFormat);
    }
}
