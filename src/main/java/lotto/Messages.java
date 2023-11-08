package lotto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import static lotto.PlaceAndPrize.Place;

public class Messages {

    public static void priceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void howManyBuy(int ticket) {
        System.out.print(ticket);
        System.out.println("개를 구매했습니다.");
    }

    public static void winNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void winsMessage(List<Integer> wins) {

        for (int i = 4; i >= 0; i--) {
            Place place = Place.values()[i];
            int matchingCount = place.getMatchPlace();
            int prizeAmount = place.getPrizeAmount();
            String formattingPrize = formatIncludeComma(prizeAmount);
            if (i == 1) {
                System.out.println(matchingCount + "개 일치, 보너스 볼 일치 (" + formattingPrize + "원) - " + wins.get(i) + "개");
            }
            System.out.println(matchingCount + "개 일치 (" + formattingPrize + "원) - " + wins.get(i) + "개");
        }
    }

    public static String formatIncludeComma(int money) {
        NumberFormat numberFormat = new DecimalFormat("#,###");
        return numberFormat.format(money);
    }

    public static void prizeMessage(int prize, double earn) {
        System.out.println("상금은 "+prize+"원 입니다.");
        System.out.println("총 수익률은 "+earn+"%입니다.");
    }
}
