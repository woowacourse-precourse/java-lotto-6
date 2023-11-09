package lotto.controller;

import java.util.List;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottoRankDto;
import lotto.domain.dto.WinningStatisticsDto;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class ViewController {

    private final InputView inputView;
    private final OutputView outputView;

    public ViewController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getCost() {
        outputView.writeAskingCost();
        return inputView.readOneNumber();
    }

    public void printLottos(List<LottoDto> lottoDtos) {
        outputView.writeLottos(lottoDtos);
    }

    public String getWinningNumbers() {
        outputView.writeAskingWinningNumbers();
        return inputView.readWinningNumbers();
    }

    public String getBonusNumber() {
        outputView.writeAskingBonusNumber();
        return inputView.readOneNumber();
    }

    public void printStatistics(WinningStatisticsDto winningStatisticsDto, LottoRankDto lottoRankDto) {
        outputView.writeWinningStatistics(winningStatisticsDto, lottoRankDto);
    }
}
