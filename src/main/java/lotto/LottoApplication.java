package lotto;

import lotto.controller.LottoController;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottosDto;
import lotto.dto.RanksDto;
import lotto.dto.WinningNumberDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.rmi.UnexpectedException;


public class LottoApplication {

    private final LottoController lottoController = new LottoController();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        LottosDto lottosDto = buyLotto(false);
        int numOfLotto = lottosDto.lottos().length;
        outputView.outputLottosMessage(lottosDto);

        WinningNumberDto winningNumberDto1 = post1stNums(false);

        WinningNumberDto winningNumberDto2 = postBonusNum(winningNumberDto1, false);
        RanksDto ranksDto = lottoController.calRanks(winningNumberDto2, lottosDto);
        outputView.outputResultMessage(ranksDto);

        outputView.outputRateOfReturnMessage(lottoController.calReturnOfRate(new LottoNumberDto(numOfLotto),ranksDto));
    }

    private LottosDto buyLotto(boolean isRedo) {
        try {
            return lottoController.buyLotto(inputView.inputMoney(isRedo));
        } catch (Exception e) {
            outputView.outputErrorMessage(e);
            return buyLotto(true);
        }

    }

    private WinningNumberDto post1stNums(boolean isRedo) {
        try {
            return lottoController.post1stNumber(inputView.input1stNums(isRedo));
        } catch (Exception e) {
            outputView.outputErrorMessage(e);
            return post1stNums(true);
        }
    }

    private WinningNumberDto postBonusNum(WinningNumberDto dto ,boolean isRedo) {
        try {
            return lottoController.postBonusNumber(dto, inputView.inputBonusNum(isRedo));
        } catch (Exception e) {
            outputView.outputErrorMessage(e);
            return postBonusNum(dto, true);
        }
    }
}
