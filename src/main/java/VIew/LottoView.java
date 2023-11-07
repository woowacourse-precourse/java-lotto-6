package VIew;

import Interface.MessagePrinter;
import Utils.LottoRank;
import Utils.Messages;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoView implements MessagePrinter {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void displayPurchasedLottoTickets(int countOfLotto, List<Lotto> lottoNumbers) {
        printMessage(countOfLotto + "개를 구매했습니다.");
        lottoNumbers.forEach(lotto -> printMessage(formatLottoNumbers(lotto.getLottoArray())));
    }

    private String formatLottoNumbers(List<Integer> lottoNumbers) {
        return "[" + lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

    public void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        printMessage(Messages.WINNING_STATISTICS);
        printMessage(Messages.UNDER_BAR);

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE) // NONE 등수는 제외
                .forEach(rank -> {
                    String description = rank.getDescription();
                    int count = statistics.getOrDefault(rank, 0);
                    printMessage(description + " - " + count + "개");
                });
    }

    public void printTotalEarnings(String earningsRateText) {
        printMessage("총 수익률은 " + earningsRateText + "입니다.");
    }

}
