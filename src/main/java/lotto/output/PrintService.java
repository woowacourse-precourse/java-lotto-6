package lotto.output;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.ListDataTypeConverter;

public class PrintService {

    public static void requestInputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestInputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void informPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void buyLottoNumbers(Map<Integer, List<Integer>> lottoNumbers) {
        for (Integer key : lottoNumbers.keySet()) {
            String lottoNumber = String.join(", ",
                ListDataTypeConverter.integerToString(lottoNumbers.get(key)));
            System.out.printf("[%s]\n", lottoNumber);
        }
    }

    public static void requestInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void announceWin() {
        System.out.println("""
            당첨통계
            ---
            """);
    }

    public static void result(Map<Integer, Integer> result) {
        Set<Integer> keys = result.keySet();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        keys.forEach(key -> {
            switch (key) {
               case 5000 -> System.out.printf("3개 일치 (%s원) - %d개\n", decimalFormat.format(key),result.get(key));
               case 50_000 -> System.out.printf("4개 일치 (%s원) - %d개\n", decimalFormat.format(key),result.get(key));
               case 1_500_000 -> System.out.printf("5개 일치 (%s원) - %d개\n", decimalFormat.format(key),result.get(key));
               case 30_000_000 -> System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", decimalFormat.format(key),result.get(key));
               case 2_000_000_000 -> System.out.printf("6개 일치 (%s원) - %d개\n", decimalFormat.format(key),result.get(key));
            }
        });
    }
    public static void error(String message) {
        System.out.printf("[ERROR] %s\n", message);
    }
    public static void totalRateOfReturn(Double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n",rate);
    }
}
