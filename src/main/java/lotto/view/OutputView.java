package lotto.view;

import lotto.dto.Purchase;
import lotto.model.Lotto;
import lotto.model.Reward;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String RESULT_LINE = "---";
    private static final String COUNT_UNIT = "개";
    private static final String RATE_MESSAGE = "총 수익률은 %s%%입니다.";

    public static void showBuying(Purchase purchase){
        int count = purchase.getCount();
        List<Lotto> lottos = purchase.getLottos();

        System.out.println();
        System.out.println(String.format("%d"+BUY_MESSAGE, count));

        for(Lotto l : lottos) System.out.println(l);
    }

    public static void showResult(EnumMap<Reward, Integer> reward){
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println(RESULT_LINE);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Reward, Integer> entry : reward.entrySet()){
            String message = entry.getKey().getMessage();
            int count = entry.getValue();
            sb.append(message).append(count).append(COUNT_UNIT).append("\n");
        }
        System.out.println(sb);
    }

    public static void showRateOfReturn(Double result){
        String rateOfReturn = String.format("%.1f", result);
        System.out.println(String.format(RATE_MESSAGE, rateOfReturn));
    }
}
