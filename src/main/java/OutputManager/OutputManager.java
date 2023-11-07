package OutputManager;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.LottoStatistics;

public class OutputManager {
    public static void printLottoData(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printTotalResult(LottoStatistics totalResult) {
        System.out.println(buildResultMsg(totalResult));
    }

    private static String buildResultMsg(LottoStatistics totalResult) {
        StringBuilder msgBuilder = new StringBuilder("");
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        Map<LottoResult, Integer> statistics = totalResult.getStatistics();
        for (LottoResult result : LottoResult.values()) {
            if (result == LottoResult.OTHER) {
                continue;
            }
            msgBuilder.append(result.getMsg());
            msgBuilder.append(statistics.get(result));
            msgBuilder.append("개\n");
        }
        msgBuilder.append("총 수익률은 ")
                .append(formatter.format(totalResult.getReturnRate()))
                .append("%입니다.\n");
        return msgBuilder.toString();
    }
}
