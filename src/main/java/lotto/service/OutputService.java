package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchResult;

import java.util.List;
import java.util.Map;

import static lotto.domain.MatchResult.*;
import static lotto.domain.constant.StringConstant.*;

public class OutputService {
    public static void printExpenseInputForm() {
        System.out.println(EXPENSE_INPUT_FORM_MESSAGE);
    }


    public static void printPurchaseResult(int ticketNum, List<Lotto> randomLottos) {
        printTicketNum(ticketNum);
        printRandomLottos(randomLottos);
    }

    private static void printTicketNum(int ticketNum) {
        System.out.println(ticketNum + TICEKTNUM_PRINT_MESSAGE);
    }

    private static void printRandomLottos(List<Lotto> randomLottos) {
        randomLottos.forEach(System.out::println);
    }


    public static void printWinningNumInputForm() {
        System.out.println(WINNING_NUM_INPUT_FORM_MESSAGE);
    }


    public static void printBonusNumInputForm() {
        System.out.println(BONUS_NUM_INPUT_FORM_MESSAGE);
    }


    public static void printResult(Map<MatchResult, Integer> result, double margin) {
        System.out.println(RESULT_PRINT_MESSAGE);
        printLottoResult(result);
        printMargin(margin);
    }

    private static void printLottoResult(Map<MatchResult, Integer> result) {
        result.keySet().forEach(matchResult -> {
            String message = matchResult.getMessage();
            int num = result.get(matchResult);

            System.out.println(message + num + MATCH_RESULT_UNIT_STRING);
        });
    }

    private static void printMargin(double margin) {
        System.out.println(MARGIN_MESSAGE_FRONT + margin + MARGIN_MESSAGE_REAR);
    }
}
