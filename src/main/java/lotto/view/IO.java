package lotto.view;

import static lotto.view.constants.Front.FIVE_AND_BONUS_MATCH;
import static lotto.view.constants.Front.FIVE_MATCH;
import static lotto.view.constants.Front.FOUR_MATCH;
import static lotto.view.constants.Front.SIX_MATCH;
import static lotto.view.constants.Front.THREE_MATCH;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.view.constants.Front;

public class IO {
    public static void requestPerchaseAmount(Front message) {
        System.out.println(message.getMessage());
    }

    public static void checkLottoTickets(final int lottoTicketCount, Front message){
        System.out.println(lottoTicketCount+message.getMessage());
    }

    public static void showLottoTickets(final List<Lotto>lottoTickets){
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public static void requestWinningNumbers(Front message){
        System.out.println(message.getMessage());
    }

    public static void requestBonusNumber(Front message){
        System.out.println(message.getMessage());
    }

    public static void showResults(Front message, Integer[]matches){
        System.out.println(message.getMessage());
        System.out.println("---");
        System.out.println(THREE_MATCH.getMessage() + String.valueOf(matches[3]) + "개");
        System.out.println(FOUR_MATCH.getMessage() + String.valueOf(matches[4]) + "개");
        System.out.println(FIVE_MATCH.getMessage() + String.valueOf(matches[5]) + "개");
        System.out.println(FIVE_AND_BONUS_MATCH.getMessage() + String.valueOf(matches[7]) + "개");
        System.out.println(SIX_MATCH.getMessage() + String.valueOf(matches[6]) + "개");
    }
}
