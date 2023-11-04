package lotto.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.utils.LottoCount;

public class OutputView {
    private final String OUTPUT_FORMAT = "당첨 통계";
    private final String OUTPUT_LINE = "---";
    public void outputCreatedLottos(List<List<Integer>> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
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
}
