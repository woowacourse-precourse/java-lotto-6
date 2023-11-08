package lotto.view;

import static lotto.view.constants.ViewConstants.FIVE_AND_BONUS_MATCH;
import static lotto.view.constants.ViewConstants.FIVE_MATCH;
import static lotto.view.constants.ViewConstants.FOUR_MATCH;
import static lotto.view.constants.ViewConstants.SIX_MATCH;
import static lotto.view.constants.ViewConstants.THREE_MATCH;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.constants.ViewConstants;

public class View {
    public static void requestPerchaseAmount(ViewConstants message) {
        System.out.println(message.getMessage());
    }

    public static void checkLottoTickets(final int lottoTicketCount, ViewConstants message){
        System.out.println();
        System.out.println(lottoTicketCount+message.getMessage());
    }

    public static void showLottoTickets(final List<Lotto>lottoTickets){
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public static void requestWinningNumbers(ViewConstants message){
        System.out.println(message.getMessage());
    }

    public static void requestBonusNumber(ViewConstants message){
        System.out.println(message.getMessage());
    }

    public static void showResults(ViewConstants message, Integer[]matches){
        System.out.println(message.getMessage());
        System.out.println("---");
        System.out.println(THREE_MATCH.getMessage() + String.valueOf(matches[3]) + "개");
        System.out.println(FOUR_MATCH.getMessage() + String.valueOf(matches[4]) + "개");
        System.out.println(FIVE_MATCH.getMessage() + String.valueOf(matches[5]) + "개");
        System.out.println(FIVE_AND_BONUS_MATCH.getMessage() + String.valueOf(matches[7]) + "개");
        System.out.println(SIX_MATCH.getMessage() + String.valueOf(matches[6]) + "개");
    }

    public static void showTotalProfit(double totalProfit){
        System.out.println("총 수익률은 " + String.valueOf(totalProfit)+"%입니다.");
    }
}
