package lotto.View;

import lotto.Model.Domain.Customer;
import lotto.Model.Domain.Lotto;
import lotto.Model.Enums.Prices;
import java.util.HashMap;
import java.util.List;

public class OutputUI {
    public static void printRequestPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printSuccessfullyPurchased(int price) {
        System.out.printf("\n%d개를 구매했습니다.%n", price);
    }
    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
    public static void printRequestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void printRequestBonusNumber(){
        System.out.print("\n보너스 번호를 입력해 주세요.\n");
    }
    public static void printResultStatistic(Customer client) {
        HashMap<String, Integer> resultPlaces = client.getResultPlaces();
        double rateOfReturn = client.calculateRateOfReturn();
        Prices[] prices = {
                Prices.WIN_5TH,
                Prices.WIN_4TH,
                Prices.WIN_3RD,
                Prices.WIN_2ND,
                Prices.WIN_1ST
        };
        String[] placeNames = {
                "3개 일치",
                "4개 일치",
                "5개 일치",
                "5개 일치, 보너스 볼 일치",
                "6개 일치"
        };

        System.out.print("\n당첨 통계\n");
        System.out.println("---");

        for (int i = 0; i < prices.length; i++) {
            int count = resultPlaces.get(prices[i].name());
            String price = formatPrice(prices[i].intValue());
            System.out.println(placeNames[i] + " (" + price + ") - " + count + "개");
        }

        System.out.println("총 수익률은 " + rateOfReturn*100 + "%입니다.");
    }
    private static String formatPrice(int price) {
        StringBuilder sb = new StringBuilder();
        sb.append(price);
        int length = sb.length();
        for (int i = length - 3; i > 0; i -= 3) {
            sb.insert(i, ',');
        }
        sb.append("원");
        return sb.toString();
    }
}
