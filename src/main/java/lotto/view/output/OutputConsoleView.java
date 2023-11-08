package lotto.view.output;

import static lotto.view.output.PrintMessage.ASKING_BONUS_NUMBER;
import static lotto.view.output.PrintMessage.ASKING_COST;
import static lotto.view.output.PrintMessage.ASKING_WINNING_NUMBERS;
import static lotto.view.output.PrintMessage.PRINT_AMOUNT;
import static lotto.view.output.PrintMessage.PRINT_FIFTH_RANK;
import static lotto.view.output.PrintMessage.PRINT_FIRST_RANK;
import static lotto.view.output.PrintMessage.PRINT_FOURTH_RANK;
import static lotto.view.output.PrintMessage.PRINT_RATE_OF_RETURN;
import static lotto.view.output.PrintMessage.PRINT_SECOND_RANK;
import static lotto.view.output.PrintMessage.PRINT_STATISTICS;
import static lotto.view.output.PrintMessage.PRINT_THIRD_RANK;

import java.util.List;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottoRankDto;
import lotto.domain.dto.WinningStatisticsDto;

public class OutputConsoleView implements OutputView {
    @Override
    public void writeAskingBonusNumber() {
        System.out.println(ASKING_BONUS_NUMBER);
    }

    @Override
    public void writeAskingCost() {
        System.out.println(ASKING_COST);
    }

    @Override
    public void writeAskingWinningNumbers() {
        System.out.println(ASKING_WINNING_NUMBERS);
    }

    @Override
    public void writeLottos(List<LottoDto> lottoDtos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_AMOUNT.toString(),lottoDtos.size())).append("\n");
        lottoDtos.forEach(lottoDto -> writeLotto(lottoDto.numbers(),sb));
        System.out.println(sb);
    }

    @Override
    public void writeWinningStatistics(WinningStatisticsDto winningStatisticsDto,
                                       LottoRankDto lottoRankDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_STATISTICS.toString(),
                writeFifthPlace(winningStatisticsDto,lottoRankDto),
                writeFourthPlace(winningStatisticsDto,lottoRankDto),
                writeThirdPlace(winningStatisticsDto,lottoRankDto),
                writeSecondPlace(winningStatisticsDto,lottoRankDto),
                writeFirstPlace(winningStatisticsDto,lottoRankDto),
                writeRateOfReturn(winningStatisticsDto)
                )
        );
        System.out.println(sb);
    }

    private void writeLotto(List<Integer> numbers, StringBuilder sb) {
        sb.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            if(i < numbers.size() - 1) {
                sb.append(numbers.get(i)).append(", ");
                continue;
            }
            sb.append(numbers.get(i)).append("]\n");
        }
    }

    private String writeFifthPlace(WinningStatisticsDto winningStatisticsDto,
                                 LottoRankDto lottoRankDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_FIFTH_RANK.toString(),lottoRankDto.standardOfFifthPlace(),
                lottoRankDto.prizeOfFifthPlace(),winningStatisticsDto.countOfFifthPlace()))
                .append("\n");
        return sb.toString();
    }
    private String writeFourthPlace(WinningStatisticsDto winningStatisticsDto,
                                 LottoRankDto lottoRankDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_FOURTH_RANK.toString(),lottoRankDto.standardOfFourthPlace(),
                        lottoRankDto.prizeOfFourthPlace(),winningStatisticsDto.countOfFourthPlace()))
                .append("\n");
        return sb.toString();
    }

    private String writeThirdPlace(WinningStatisticsDto winningStatisticsDto,
                                  LottoRankDto lottoRankDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_THIRD_RANK.toString(),lottoRankDto.standardOfThirdPlace(),
                        lottoRankDto.prizeOfThirdPlace(),winningStatisticsDto.countOfThirdPlace()))
                .append("\n");
        return sb.toString();
    }

    private String writeSecondPlace(WinningStatisticsDto winningStatisticsDto,
                                  LottoRankDto lottoRankDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_SECOND_RANK.toString(),lottoRankDto.standardOfSecondPlace(),
                        lottoRankDto.prizeOfSecondPlace(),winningStatisticsDto.countOfSecondPlace()))
                .append("\n");
        return sb.toString();
    }

    private String writeFirstPlace(WinningStatisticsDto winningStatisticsDto,
                                  LottoRankDto lottoRankDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_FIRST_RANK.toString(),lottoRankDto.standardOfFirstPlace(),
                        lottoRankDto.prizeOfFirstPlace(),winningStatisticsDto.countOfFirstPlace()))
                .append("\n");
        return sb.toString();
    }

    private String writeRateOfReturn(WinningStatisticsDto winningStatisticsDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_RATE_OF_RETURN.toString(),winningStatisticsDto.rateOrReturn()));
        return sb.toString();
    }

}
