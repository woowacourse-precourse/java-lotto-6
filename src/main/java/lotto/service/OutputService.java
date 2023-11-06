package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchResult;

import java.util.List;
import java.util.Map;

import static lotto.domain.MatchResult.NONE;
import static lotto.domain.constant.StringConstant.*;

@SuppressWarnings("SameParameterValue")
public class OutputService {
    public static void printExpenseInputForm() {
        System.out.println(EXPENSE_INPUT_FORM_MESSAGE);
    }


    public static void printPurchaseResult(int ticketNum, List<Lotto> randomLottos) {
        printBlankLines(1);

        printTicketNum(ticketNum);
        printRandomLottos(randomLottos);
    }

    private static void printTicketNum(int ticketNum) {
        System.out.println(ticketNum + TICEKTNUM_PRINT_MESSAGE);
    }

    private static void printRandomLottos(List<Lotto> randomLottos) {
        randomLottos.forEach(lotto ->
                System.out.println(lotto.getNumbers())
        );
    }


    public static void printWinningNumInputForm() {
        printBlankLines(1);

        System.out.println(WINNING_NUM_INPUT_FORM_MESSAGE);
    }


    public static void printBonusNumInputForm() {
        printBlankLines(1);

        System.out.println(BONUS_NUM_INPUT_FORM_MESSAGE);
    }


    public static void printResult(Map<MatchResult, Integer> result, double margin) {
        printBlankLines(1);

        System.out.println(RESULT_PRINT_MESSAGE);
        printLottoResult(result);
        printMargin(margin);
    }

    private static void printLottoResult(Map<MatchResult, Integer> result) {
        result.keySet().forEach(matchResult -> {
            String message = matchResult.getMessage();
            int num = result.get(matchResult);

            if (!matchResult.equals(NONE))
                System.out.println(message + num + MATCH_RESULT_UNIT_STRING);
        });
    }

    private static void printMargin(double margin) {
        System.out.println(MARGIN_MESSAGE_FRONT + margin + MARGIN_MESSAGE_REAR);
    }


    private static void printBlankLines(int line) {
        for (int i = 0; i < line; i++)
            System.out.println();
    }
}
