package lotto.io;

import lotto.configure.DomainConfiguration;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.util.Utils;

import java.util.List;

import static lotto.configure.OutputConfiguration.*;

public class OutputAdaptor {

    public static void displayErrorMessage(String errorMessage) {
        Printer.print(errorMessage + LINE_BRAKING);
    }

    public static void displayMessageToPromptToInputPurchasePrice() {
        Printer.print(MESSAGE_TO_PROMPT_TO_INPUT_PURCHASE_PRICE + LINE_BRAKING);
    }

    public static void displayLottoNumbers(List<Lotto> lottos) {
        Printer.print(LINE_BRAKING + lottos.size() + NOTIFICATION_FORMAT_OF_NUM_OF_LOTTO + LINE_BRAKING);
        lottos.forEach((lotto -> Printer.print(lotto.toString() + LINE_BRAKING)));
    }

    public static void displayMessageToPromptToInputWinningNumbers() {
        Printer.print(LINE_BRAKING + MESSAGE_TO_PROMPT_TO_INPUT_WINNING_NUMBERS + LINE_BRAKING);
    }

    public static void displayMessageToPromptToInputBonusNumber() {
        Printer.print(LINE_BRAKING + MESSAGE_TO_PROMPT_TO_INPUT_BONUS_NUMBER + LINE_BRAKING);
    }

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
