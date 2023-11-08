package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InitDto initDto;
    private final OutputView outputView = new OutputView();
    public void start() {
        Buyer buyer = InputView.payForLottery();
        Winning winning = InputView.inputBonusNum(InputView.inputWinningNum());
        initDto = new InitDto(buyer, winning);
    }

    public void running() {
        outputView.getStatistic(initDto.getBuyer(), initDto.getWinning());
    }

    public void exit() {
        outputView.earningRatio(initDto.getBuyer());
    }
}
