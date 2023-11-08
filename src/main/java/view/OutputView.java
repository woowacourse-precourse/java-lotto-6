package view;

import dto.Purchase;
import model.Lotto;
import model.Reward;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String BUY_MESSAGE = "개를 구매했습니다.";

    public static void showBuying(Purchase purchase){
        int count = purchase.getCount();
        List<Lotto> lottos = purchase.getLottos();

        System.out.println();
        System.out.println(String.format("%d"+BUY_MESSAGE, count));

        for(Lotto l : lottos) System.out.println(l);
    }

    public static void showResult(EnumMap<Reward, Integer> reward){
        System.out.println("당첨 통계");
        System.out.println("---");

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Reward, Integer> entry : reward.entrySet()){
            String message = entry.getKey().getMessage();
            int count = entry.getValue();
            sb.append(message).append(count).append("개").append("\n");
        }
        System.out.println(sb);
    }

    public static void showRateOfReturn(Double result){
        String rateOfReturn = String.format("%.1f", result);
        System.out.println(String.format("총 수익률은 %s%%입니다.", rateOfReturn));
    }
}
