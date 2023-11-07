package lotto.view;

import static lotto.domain.Result.FIVE_AND_BONUS_MATCH;
import static lotto.domain.Result.FIVE_MATCH;
import static lotto.domain.Result.FOUR_MATCH;
import static lotto.domain.Result.SIX_MATCH;
import static lotto.domain.Result.THREE_MATCH;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.domain.Result;
import lotto.utils.ErrorMessage;
import lotto.utils.Message;

public class OutputView {
    private OutputView() {
    }

    public static void printBuyInputPrice() {
        System.out.println(Message.PRINT_USER_INPUT_BUY_PRICE.getMessage());
    }

    public static void printBuyLottoCount(int count) {
        System.out.println();
        System.out.println(count + Message.PRINT_USER_BUY_LOTTO_COUNT.getMessage());
    }

    public static void printLotties(List<List<Integer>> lottos){
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printEnterWinningNumber(){
        System.out.println();
        System.out.println(Message.PRINT_USER_ENTER_WINNING_NUMBER.getMessage());
    }

    public static void printEnterBonusNumber(){
        System.out.println();
        System.out.println(Message.PRINT_USER_ENTER_BONUS_NUMBER.getMessage());
    }

    private static void printWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }




}
