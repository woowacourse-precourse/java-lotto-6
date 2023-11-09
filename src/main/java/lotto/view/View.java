package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.IssuedLottoDto;
import lotto.dto.WinningStatisticsDto;

public class View {

    private static final String OPEN_SQUARE_BRACKETS = "[";
    private static final String CLOSE_SQUARE_BRACKETS = "]";


    public void printRequestPriceMessage() {
        System.out.println(ViewMessage.REQUEST_PURCHASE_PRICE_MESSAGE.getMessage());
    }

    public void printNumberOfPurchasedLotto(int number) {
        System.out.printf(ViewMessage.NUMBER_OF_PURCHASED_LOTTO_FORMAT.getMessage(), number);
    }

    public void printIssuedLottoNumbers(List<IssuedLottoDto> lottos) {
        for (IssuedLottoDto lotto : lottos) {
            List<Integer> numbers = lotto.numbers();
            String message = numbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(OPEN_SQUARE_BRACKETS + message + CLOSE_SQUARE_BRACKETS);
        }
    }

    public void printRequestWinningNumbers() {
        System.out.println(ViewMessage.REQUEST_WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void printRequestBonusNumber() {
        System.out.println(ViewMessage.REQUEST_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void printWinningStatistics(WinningStatisticsDto winDto) {
        System.out.println(ViewMessage.WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(ViewMessage.DIVIDER_MESSAGE.getMessage());
        printWinningCount(winDto);
        System.out.printf(ViewMessage.TOTAL_RETURN_FORMAT.getMessage(), winDto.earningRate());
    }

    private void printWinningCount(WinningStatisticsDto winDto) {
        System.out.printf(ViewMessage.WINNING_MATCHES_THREE_FORMAT.getMessage(), winDto.threeMatches());
        System.out.printf(ViewMessage.WINNING_MATCHES_FOUR_FORMAT.getMessage(), winDto.fourMatches());
        System.out.printf(ViewMessage.WINNING_MATCHES_FIVE_NO_BONUS_FORMAT.getMessage(), winDto.fiveMatches());
        System.out.printf(ViewMessage.WINNING_MATCHES_FIVE_WITH_BONUS_FORMAT.getMessage(),
                winDto.fiveMatchesWithBonus());
        System.out.printf(ViewMessage.WINNING_MATCHES_SIX_FORMAT.getMessage(), winDto.sixMatches());
    }


}
