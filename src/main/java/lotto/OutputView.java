package lotto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.LottoWinningStatus.*;

public class OutputView {
    private static final String REQUEST_INPUT_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String REQUEST_INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATUS_MESSAGE = "당첨 통계";
    private static final String DASH_SPLIT_SIGN = "---";
    private static final String GENERAL_MATCH_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개 \n";
    private static final String BONUS_MATCH_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개 \n";
    public static final String TOTAL_REWARD_RETURN_MESSAGE = "총 수익률은 ";
    public static final String PERCENT_MESSAGE = "%입니다.";
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();

    public void printRequestInputBuyMoney() {
        System.out.println(REQUEST_INPUT_BUY_MONEY_MESSAGE);
    }

    public void printLottoTicket(int buyTicket) {
        printEmptyLine();
        System.out.println(buyTicket + BUY_COUNT_MESSAGE);
    }

    public void printLottoNumbers(List<List<Integer>> lottoNumberStore) {
        for (List<Integer> lottoNumber : lottoNumberStore) {
            List<Integer> copyLottoNumber = new ArrayList<>(lottoNumber);
            Collections.sort(copyLottoNumber);
            System.out.println(copyLottoNumber);
        }
    }

    public void printRequestInputWinningNumber() {
        printEmptyLine();
        System.out.println(REQUEST_INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printRequestInputBonusNumber() {
        printEmptyLine();
        System.out.println(REQUEST_INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatus() {
        printEmptyLine();
        System.out.println(WINNING_STATUS_MESSAGE);
        System.out.println(DASH_SPLIT_SIGN);
    }

    public void printLottoMatchResult(Map<Integer, Integer> lottoResultStore) {
        System.out.printf(GENERAL_MATCH_RESULT_MESSAGE, FIFTH_AWARD.getMatchCount(),
                NUMBER_FORMAT.format(FIFTH_AWARD.getRewardMoney()), lottoResultStore.get(FIFTH_AWARD.getRewardMoney()));
        System.out.printf(GENERAL_MATCH_RESULT_MESSAGE, FOURTH_AWARD.getMatchCount(),
                NUMBER_FORMAT.format(FOURTH_AWARD.getRewardMoney()), lottoResultStore.get(FOURTH_AWARD.getRewardMoney()));
        System.out.printf(GENERAL_MATCH_RESULT_MESSAGE, THIRD_AWARD.getMatchCount(),
                NUMBER_FORMAT.format(THIRD_AWARD.getRewardMoney()), lottoResultStore.get(THIRD_AWARD.getRewardMoney()));
        System.out.printf(BONUS_MATCH_RESULT_MESSAGE, SECOND_AWARD.getMatchCount(),
                NUMBER_FORMAT.format(SECOND_AWARD.getRewardMoney()), lottoResultStore.get(SECOND_AWARD.getRewardMoney()));
        System.out.printf(GENERAL_MATCH_RESULT_MESSAGE, FIRST_AWARD.getMatchCount(),
                NUMBER_FORMAT.format(FIRST_AWARD.getRewardMoney()), lottoResultStore.get(FIRST_AWARD.getRewardMoney()));
    }

    public void printTotalReturn(double inputMoney) {
        System.out.print(TOTAL_REWARD_RETURN_MESSAGE + inputMoney + PERCENT_MESSAGE);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
