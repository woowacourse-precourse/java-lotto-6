package lotto;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String AMOUNT_OF_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String FIRST_RESULT_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String SECOND_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String THIRD_RESULT_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String FOURTH_RESULT_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String FIFTH_RESULT_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String MATCH_MESSAGE = "개";
    private static final String RATE_OF_RETURN_HEAD_MESSAGE = "총 수익률은 ";
    private static final String RATE_OF_RETURN_TAIL_MESSAGE = "%입니다.";

    public static void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }
    public static void printAmountOfLotto(int count){
        System.out.println(count + AMOUNT_OF_LOTTO_MESSAGE);
    }
    public static void printLotto(HashMap<Integer, Lotto> lotties) {
        for (int i = 0; i < lotties.size(); i++) {
            System.out.println(lotties.get(i).getLotto());
        }
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }
    public static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }
    public static void printResultMessage(HashMap<Integer, Integer> finalResult) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(LINE);
        System.out.println(FIFTH_RESULT_MESSAGE + finalResult.get(5) + MATCH_MESSAGE);
        System.out.println(FOURTH_RESULT_MESSAGE + finalResult.get(4) + MATCH_MESSAGE);
        System.out.println(THIRD_RESULT_MESSAGE + finalResult.get(3) + MATCH_MESSAGE);
        System.out.println(SECOND_RESULT_MESSAGE + finalResult.get(2) + MATCH_MESSAGE);
        System.out.println(FIRST_RESULT_MESSAGE + finalResult.get(1) + MATCH_MESSAGE);
    }

    public static void printRateOfReturn(String ror) {
        System.out.println(RATE_OF_RETURN_HEAD_MESSAGE + ror + RATE_OF_RETURN_TAIL_MESSAGE);
    }
}
