package view;

import constant.ConstantNumber;
import mapper.dto.GameResultDto;
import mapper.dto.LottoDto;

import java.util.List;
import java.util.stream.Collectors;

import static constant.OutputMessage.*;

public class OutputView {
    private static final String PREFIX = "[";
    private static final String POSTFIX = "]\n";
    private static final String DELIMITER = ", ";
    private static final int RANK_2_INDEX = 2;
    public void inputPurchaseAmount() {
        System.out.print(INPUT_PURCHASE_AMOUNT.get());
    }

    public void buyLottoes(int count) {
        System.out.print(BUY_LOTTOES.get(count));
    }

    public void lottoTickets(List<LottoDto> lottoDtoes) {
        for (int i = 0; i < lottoDtoes.size(); i++) {
            String result = PREFIX;
            result += lottoDtoes.get(i).getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(DELIMITER));
            result += POSTFIX;
            System.out.print(result);
        }
    }

    public void inputWinningNumber() {
        System.out.print(INPUT_WINNING_NUMBER.get());
    }

    public void inputBonusNumber() {
        System.out.print(INPUT_BONUS_NUMBER.get());
    }

    public void winningStatistics(GameResultDto gameResultDto) {
        System.out.print(WINNING_STATISTICS.get());
        printMatchCount(gameResultDto);
        printTotalRateOfReturn(gameResultDto);
    }

    private void printMatchCount(GameResultDto gameResultDto) {
        for (int i = ConstantNumber.COUNT_OF_WINNING_PRIZE.get(); i >= 1 ; i--) {
            if (i == RANK_2_INDEX) {
                System.out.print(MATCH_COUNT_RANK_2.get(i, gameResultDto.getRankCount(i)));
                continue;
            }
            System.out.print(MATCH_COUNT.get(i, gameResultDto.getRankCount(i)));
        }
    }

    private void printTotalRateOfReturn(GameResultDto gameResultDto) {
        System.out.print(TOTAL_RATE_OF_RETURN.get(gameResultDto.getRateOfReturn()));
    }

    public void exceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
