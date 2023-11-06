package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.WinningResultDto;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    private ConsoleOutputView() {
    }

    private static class ConsoleOutputViewHolder {
        private static ConsoleOutputView consoleOutputView = new ConsoleOutputView();
    }

    public static ConsoleOutputView getInstance() {
        return ConsoleOutputView.ConsoleOutputViewHolder.consoleOutputView;
    }

    @Override
    public void printUserLotto(List<LottoDto> lottoDtos) {
        print(OutputMessage.getUserLottoCountMessage(lottoDtos.size()));
        lottoDtos.stream()
                .forEach(lottoDto -> print(lottoDto.getNumbers()));
    }

    @Override
    public void printWinningResult(WinningResultDto winningResultDto) {
        print(OutputMessage.getWinningResultStartMessage());

        winningResultDto.getRankingDtos().stream()
                .forEach(rankingDto -> {
                    if (rankingDto.getRankingNumber().equals("FAIL")) return;
                    print(OutputMessage.getWinningResultMessage(rankingDto));
                });

        print(OutputMessage.getRateOfReturnMessage(winningResultDto));
    }
}
