package lotto.Enum;

import static lotto.Enum.ErrorMessage.INDEX_OUT_OF_RANGE_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum OutputMessage {
    TOTAL_RATE_OF_RETURN("\n총 수익률은 "),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    BUY_HOW_MANY("개를 구매했습니다."),

    PRINT_CORRECTS("", "", "", "3개 일치", "4개 일치", "5개 일치", "6개 일치", "5개 일치, 보너스 볼 일치");

    private final List<String> matchMessages;
    private final String message;

    OutputMessage(String message) {
        this.message = message;
        this.matchMessages = null;
    }

    OutputMessage(String... messages) {
        matchMessages = new ArrayList<>();
        Collections.addAll(matchMessages, messages);
        this.message = null;
    }

    public String getMessage() {
        return this.message;
    }

    public static String printBuyHowManyLottoMessage(int number) {
        return "\n" + number + BUY_HOW_MANY.getMessage();
    }

    public static String printGuessedLotto(String message, String commaNum, int value) {
        return message + " (" + commaNum + "원) - " + value + "개";
    }

    public static String printTotalRateOfReturn(double totalRateOfReturn){
        return TOTAL_RATE_OF_RETURN.getMessage() + totalRateOfReturn + "%입니다.";
    }

    public String getCorrectMessageByIndex(int index) {
        if (index < 3 && index > matchMessages.size()) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_RANGE_ERROR.getMessage());
        }
        return matchMessages.get(index);
    }
}