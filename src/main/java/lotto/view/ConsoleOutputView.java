package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.WinningResultDto;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    private final OutputMessage outputMessage;

    private ConsoleOutputView(OutputMessage outputMessage) {
        this.outputMessage = outputMessage;
    }

    private static class ConsoleOutputViewHolder {
        private static ConsoleOutputView consoleOutputView = new ConsoleOutputView(OutputMessage.getInstance());
    }

    public static ConsoleOutputView getInstance() {
        return ConsoleOutputView.ConsoleOutputViewHolder.consoleOutputView;
    }

    @Override
    public void printLottos(List<LottoDto> lottoDtos) {
        print(OutputMessage.getUserLottoCountMessage(lottoDtos.size()));
        lottoDtos.stream()
                .forEach(lottoDto -> print(lottoDto.numbers()));
    }

    @Override
    public void printWinningResult(WinningResultDto winningResultDto) {
        print(OutputMessage.getWinningResultStartMessage());
        printRanking(winningResultDto);
        printReturnRate(winningResultDto);
    }

    private void printRanking(WinningResultDto winningResultDto) {
        winningResultDto.rankingDtos().stream()
                .forEach(rankingDto -> {
                    if (rankingDto.rankingNumber().equals("FAIL")) return;
                    print(OutputMessage.getWinningResultMessage(rankingDto));
                });
    }

    private void printReturnRate(WinningResultDto winningResultDto) {
        print(OutputMessage.getReturnRateMessage(winningResultDto));
    }
}
