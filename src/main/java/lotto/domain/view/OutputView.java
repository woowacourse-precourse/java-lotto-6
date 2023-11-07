package lotto.domain.view;

import java.util.List;
import java.util.Map;
import lotto.domain.repository.Lotto;
import lotto.enums.UserInterfaceMessage;

public class OutputView {
    public void printPublishCount(int size) {
        System.out.println(String.format(UserInterfaceMessage.COUNT_BOUGHT.getValue() + "\n", size));
    }

    public void printPublishedLottoNumbers(List<Lotto> publishedLottoNumbers) {
        for (Lotto publishedLotto : publishedLottoNumbers) {
            System.out.println(publishedLotto.getNumbers());
        }
    }

    public void printResultMessage() {
        System.out.println(UserInterfaceMessage.PRIZE_STATS.getValue());
        System.out.println("---");
    }

    public void printRewardResult(Map<String, Integer> matchResult) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String key : matchResult.keySet()) {
            stringBuffer.append(String.format(UserInterfaceMessage.MATCH_COUNT.getValue(),
                            Integer.parseInt(key.substring(0, 1))))
                    .append(rewards().get(key)).append(" - ").append(matchResult.get(key))
                    .append(UserInterfaceMessage.EA.getValue()).append("\n");
        }
        System.out.println(stringBuffer);
    }

    private Map<String, String> rewards() {
        return Map.of("30", UserInterfaceMessage.REWARDS_THREE_MATCH.getValue(),
                "40", UserInterfaceMessage.REWARDS_FORE_MATCH.getValue(),
                "50", UserInterfaceMessage.REWARDS_FIVE_MATCH.getValue(),
                "51", UserInterfaceMessage.REWARDS_FIVE_BONUS_MATCH.getValue(),
                "60", UserInterfaceMessage.REWARDS_SIX_MATCH.getValue());
    }

    public void printEarnings(double earnings) {
        System.out.print(String.format(UserInterfaceMessage.TOTAL_EARNINGS_RATE.getValue(), earnings));
    }
}
