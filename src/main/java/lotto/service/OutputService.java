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
        System.out.println(THREE_MATCH_RESULT_MESSAGE + result.get(THREE) + MATCH_RESULT_UNIT_STRING);
        System.out.println(FOUR_MATCH_RESULT_MESSAGE + result.get(FOUR) + MATCH_RESULT_UNIT_STRING);
        System.out.println(FIVE_MATCH_RESULT_MESSAGE + result.get(FIVE) + MATCH_RESULT_UNIT_STRING);
        System.out.println(BONUS_MATCH_RESULT_MESSAGE + result.get(BONUS) + MATCH_RESULT_UNIT_STRING);
        System.out.println(SIX__MATCH_RESULT_MESSAGE + result.get(SIX) + MATCH_RESULT_UNIT_STRING);
    }

    private static void printMargin(double margin) {
        System.out.println(MARGIN_MESSAGE_FRONT + margin + MARGIN_MESSAGE_REAR);
    }
}
