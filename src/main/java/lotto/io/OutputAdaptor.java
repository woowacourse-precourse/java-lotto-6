package lotto.io;

import lotto.configure.DomainConfiguration;
import lotto.configure.ErrorMessages;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.util.Utils;

import java.util.List;

import static lotto.configure.OutputConfiguration.*;

public class OutputAdaptor {

    /**
     * 에러 메시지를 출력한다.
     * 에러 메시지는 다음과 같은 형태를 취한다.
     * "[ERROR] (errorMessage)\n"
     * @param errorMessage 표시할 에러 메시지.
     */
    public static void displayErrorMessage(String errorMessage) {
        Printer.print(ErrorMessages.ERROR_MESSAGE_COMMON_PREFIX.get() + " " + errorMessage + LINE_BRAKING);
    }

    /**
     * 구입 금액을 입력하라는 메시지를 출력한다.
     */
    public static void displayMessageToPromptToInputPurchasePrice() {
        Printer.print(MESSAGE_TO_PROMPT_TO_INPUT_PURCHASE_PRICE + LINE_BRAKING);
    }

    /**
     * 발행된 로또 번호를 모두 출력한다.
     * 개별 로또 번호의 출력 형식은 Lotto.toString에 정의돼 있다.
     * @param lottos 출력할 모든 로또가 담긴 리스트.
     */
    public static void displayLottoNumbers(List<Lotto> lottos) {
        Printer.print(LINE_BRAKING + lottos.size() + NOTIFICATION_FORMAT_OF_NUM_OF_LOTTO + LINE_BRAKING);
        lottos.forEach((lotto -> Printer.print(lotto.toString() + LINE_BRAKING)));
    }

    /**
     * 당첨 번호를 입력하라는 메시지를 출력한다.
     */
    public static void displayMessageToPromptToInputWinningNumbers() {
        Printer.print(LINE_BRAKING + MESSAGE_TO_PROMPT_TO_INPUT_WINNING_NUMBERS + LINE_BRAKING);
    }

    /**
     * 보너스 번호를 입력하라는 메시지를 출력한다.
     */
    public static void displayMessageToPromptToInputBonusNumber() {
        Printer.print(LINE_BRAKING + MESSAGE_TO_PROMPT_TO_INPUT_BONUS_NUMBER + LINE_BRAKING);
    }

    /**
     * 결과를 출력한다.
     * 결과 출력 예시는 다음과 같다.
     * "
     * 당첨 통계
     * ---
     * 3개 일치 (5,000원) - 1개
     * 4개 일치 (50,000원) - 0개
     * 5개 일치 (1,500,000원) - 0개
     * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
     * 6개 일치 (2,000,000,000원) - 0개"
     * @param result
     */
    public static void displayResult(Result result) {
        Printer.print(LINE_BRAKING + WINNING_SUM);
        List<Integer> matches = DomainConfiguration.RANK_PER_NUM_OF_MATCHES.keySet().stream().sorted().toList();
        for (Integer match : matches) {
            Integer rank = DomainConfiguration.RANK_PER_NUM_OF_MATCHES.get(match);
            if (rank.equals(DomainConfiguration.RANK_FOR_CHECK_BONUS_NUMBER)) {
                forBonusNumber(result, match, rank);
                continue;
            }
            Printer.print(getFormattedString(match, DomainConfiguration.REWARD_PER_RANK.get(rank),
                    result.getCount(rank), ""));
        }
    }

    private static void forBonusNumber(Result result, Integer match, Integer rank) {
        Printer.print(getFormattedString(match, DomainConfiguration.REWARD_PER_RANK.get(rank + 1),
                result.getCount(rank + 1), ""));
        Printer.print(getFormattedString(match, DomainConfiguration.REWARD_PER_RANK.get(rank),
                result.getCount(rank), ", " + MATCH_BONUS_NUMBER));
    }

    private static String getFormattedString(int match, int reward, int count, String forBonus) {
        return match + NUM_OF_MATCHES + forBonus + " (" + formatReward(reward) + WON + ") - "
                + count + COUNT + LINE_BRAKING;
    }

    private static String formatReward(int reward) {
        String asString = String.valueOf(reward);
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = asString.length() - WHERE_TO_SEPARATOR_IN_MONEY; i >= 0; i -= WHERE_TO_SEPARATOR_IN_MONEY) {
            sb.insert(0, asString.substring(i, i + WHERE_TO_SEPARATOR_IN_MONEY));
            sb.insert(0, ",");
        }
        sb.insert(0, asString.substring(0, i + WHERE_TO_SEPARATOR_IN_MONEY));
        return sb.toString();
    }

    public static void displayRateOfProfit(double rateOfProfit) {
        Printer.print(RATE_OF_RETURN_PREFIX + Utils.round(rateOfProfit) + RATE_OF_RETURN_SUFFIX + LINE_BRAKING);
    }
}
