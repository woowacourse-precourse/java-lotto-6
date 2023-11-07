package lotto.view;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class OutputView {
    public static void printQuantityOfLotto(int quantity){
        System.out.println(quantity+"개를 구매했습니다.");
    }
    public static void printRequestPurchaseAmont(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printRequestWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLotto(List<Integer> lottos){
        String result=lottos.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ","[","]"));
        System.out.println(result);
    }
    public static void printWinningStatics(List<LottoResult> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<LottoResult, Integer> resultCounts = new HashMap<>();
        for (LottoResult result : results) {
            resultCounts.put(result, resultCounts.getOrDefault(result, 0) + 1);
        }

        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for (LottoResult result : LottoResult.values()) {
            if (result != LottoResult.NONE) {
                int count = resultCounts.getOrDefault(result, 0);
                String description = (result == LottoResult.SECOND) ?
                        "5개 일치, 보너스 볼 일치 (" + decimalFormat.format(result.getPrize()) + "원)" :
                        result.getMatchCount() + "개 일치 (" + decimalFormat.format(result.getPrize()) + "원)";
                System.out.println(description + " - " + count + "개");
            }
        }
    }


    public static void printTotalRevenue(double revenue){
        System.out.printf("총 수익률은 %.1f%%입니다.%n", revenue);
    }
}
