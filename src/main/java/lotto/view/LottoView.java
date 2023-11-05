package lotto.view;

import static lotto.view.message.OutputMessage.ANNOUNCE_FOR_PURCHASE;
import static lotto.view.message.OutputMessage.WINNING_STATISTICS;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.FIVE_AND_BONUS_MATCH;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.FIVE_MATCH;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.FOUR_MATCH;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.SIX_MATCH;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.THREE_MATCH;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottoResultDto;
import lotto.view.message.OutputMessage;
import lotto.view.message.OutputMessage.WinningStatisticsDetails;

public class LottoView {
    public String readInput() {
        return Console.readLine();
    }

    public void closeInput() {
        Console.close();
    }

    public void displayMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    private void displayFormattedMessage(WinningStatisticsDetails details, int number) {
        System.out.printf(details.getDetail(number));
    }

    private void displayFormattedMessage(OutputMessage formattedMessage, float percentage) {
        System.out.printf(formattedMessage.getMessage(), percentage);
    }

    public void displayLottoNumber(LottoNumberDto numberDto) {
        List<Lotto> lottos = numberDto.getLottos();
        lottos.stream().map(Lotto::getNumbers)
                .map(numbers -> numbers.stream().sorted().toList())
                .forEach(System.out::println);
    }

    public void displayStatistics(LottoResultDto resultDto) {
        displayMessage(WINNING_STATISTICS);

        List<Integer> winResults = resultDto.getWinResults();
        float profitPercentage = resultDto.getProfitPercentage();

        displayFormattedMessage(THREE_MATCH, winResults.get(1));
        displayFormattedMessage(FOUR_MATCH, winResults.get(2));
        displayFormattedMessage(FIVE_MATCH, winResults.get(3));
        displayFormattedMessage(FIVE_AND_BONUS_MATCH, winResults.get(4));
        displayFormattedMessage(SIX_MATCH, winResults.get(5));
        displayFormattedMessage(ANNOUNCE_FOR_PURCHASE, profitPercentage);
    }
}
