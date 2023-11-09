package lotto.view;

import lotto.domain.WinningType;
import lotto.dto.LottoNumbers;
import lotto.dto.WinningStatus;

import java.text.NumberFormat;
import java.util.List;

public class DisplayFormatter {

    private DisplayFormatter() {
    }

    public static String formatLottoNumbers(LottoNumbers lottoNumbers) {
        List<Integer> numbers = lottoNumbers.numbers();
        List<String> sortedNumbers = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .toList();
        return "[" + String.join(", ", sortedNumbers) + "]";
    }

    public static String formatWinningStatus(WinningStatus winningStatus) {
        WinningType winningType = winningStatus.winningType();
        int matchesCount = winningType.getMatchesCount();
        int reward = winningType.getReward();
        boolean isBonus = winningType.isBonus();
        int count = winningStatus.count();

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String formattedReward = numberFormat.format(reward);

        return String.format("%d개 일치%s (%s원) - %d개", matchesCount, bonusMatchMessage(isBonus), formattedReward, count);
    }

    private static String bonusMatchMessage(boolean isBonus) {
        if (isBonus) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
