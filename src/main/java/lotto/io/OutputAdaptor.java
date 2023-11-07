package lotto.io;

import lotto.configure.DomainConfiguration;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.util.Utils;

import java.util.Collections;
import java.util.List;

import static lotto.configure.OutputConfiguration.*;

public class OutputAdaptor {

    public static void displayMessageToPromptToInputPurchasePrice() {
        Printer.print(MESSAGE_TO_PROMPT_TO_INPUT_PURCHASE_PRICE + LINE_BRAKING);
    }

    public static void displayLottoNumbers(List<Lotto> lottos) {
        Printer.print(LINE_BRAKING + lottos.size() + NOTIFICATION_FORMAT_OF_NUM_OF_LOTTO + LINE_BRAKING);
        lottos.forEach((lotto -> Printer.print(lottos.toString() + LINE_BRAKING)));
    }

    public static void displayMessageToPromptToInputWinningNumbers() {
        Printer.print(LINE_BRAKING + MESSAGE_TO_PROMPT_TO_INPUT_WINNING_NUMBERS + LINE_BRAKING);
    }

    public static void displayMessageToPromptToInputBonusNumber() {
        Printer.print(LINE_BRAKING + MESSAGE_TO_PROMPT_TO_INPUT_BONUS_NUMBER + LINE_BRAKING);
    }

    public static void displayResult(Result result) {
        Printer.print(LINE_BRAKING + WINNING_SUM + LINE_BRAKING);
        List<Integer> matches = DomainConfiguration.RANK_PER_NUM_OF_MATCHES.keySet().stream().sorted().toList();
        for (Integer match : matches) {
            Integer rank = DomainConfiguration.RANK_PER_NUM_OF_MATCHES.get(match);
            if (rank.equals(DomainConfiguration.RANK_FOR_CHECK_BONUS_NUMBER)) {
                int rewardWithoutBonusMatch = DomainConfiguration.REWARD_PER_RANK.get(rank + 1);
                int rewardWithBonusMatch = DomainConfiguration.REWARD_PER_RANK.get(rank);
                Printer.print(
                        match + NUM_OF_MATCHES + " (" + formatReward(rewardWithoutBonusMatch)
                        + WON + ") - " + result.getCount(rank + 1) + COUNT
                );
                Printer.print(
                        match + NUM_OF_MATCHES + ", " + MATCH_BONUS_NUMBER
                        + " (" + formatReward(rewardWithBonusMatch)
                        + WON + ") - " + result.getCount(rank) + COUNT
                );
            }
        }
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
        Printer.print(RATE_OF_RETURN_PREFIX + Utils.round(rateOfProfit) + RATE_OF_RETURN_PREFIX + LINE_BRAKING);
    }
}
