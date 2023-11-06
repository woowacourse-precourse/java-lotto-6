package lotto.controller;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.dto.LottoResponseDtos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int count = getAmount();
        LottoResponseDtos lottosDto = createLottos(count);
        WinningNumber winningNumber = getWinningNumber();
    }

    private int getAmount() {
        String money = inputView.getPurchaseAmount();
        Amount amount = new Amount(money);
        return amount.getLottoCount();
    }

    private LottoResponseDtos createLottos(int count) {
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = new Lottos(lottoMachine.createAllLotto(count));
        LottoResponseDtos lottosDto = lottos.toResponseDto();
        outputView.printLottos(count, lottosDto);
        return lottosDto;
    }

    private WinningNumber getWinningNumber() {
        String numbers = inputView.getWinningNumber();
        String bonusNumber = inputView.getBonusNumber();
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);
        return winningNumber;
    }
}
