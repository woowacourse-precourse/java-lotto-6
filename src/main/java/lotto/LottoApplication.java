package lotto;

import lotto.controller.LottoController;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottosDto;
import lotto.dto.RanksDto;
import lotto.dto.WinningNumberDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    private final LottoController lottoController = new LottoController();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        LottosDto lottosDto = buyLotto(false);
        if (lottosDto != null) {
            WinningNumberDto winningNumberDto = postBonusNum(post1stNums(false), false);
            if (winningNumberDto != null) {
                checkLottoResult(lottosDto, winningNumberDto);
            }
        }
    }

    private LottosDto buyLotto(boolean isRedo) {
        try {
            LottosDto dto = lottoController.buyLotto(inputView.inputMoney(isRedo));
            outputView.outputLottosMessage(dto);
            return dto;
        } catch (Exception e) {
            if (e.getMessage().equals("No line found")) {
                return null;
            }
            outputView.outputErrorMessage(e);
            return buyLotto(true);
        }
    }

    private void checkLottoResult(LottosDto lottosDto, WinningNumberDto winningNumberDto) {
        int numOfLotto = lottosDto.lottos().length;
        RanksDto ranksDto = lottoController.calRanks(winningNumberDto, lottosDto);
        outputView.outputResultMessage(ranksDto);
        outputView.outputRateOfReturnMessage(lottoController.calReturnOfRate(new LottoNumberDto(numOfLotto),ranksDto));
    }

    private WinningNumberDto post1stNums(boolean isRedo) {
        try {
            return lottoController.post1stNumber(inputView.input1stNums(isRedo));
        } catch (Exception e) {
            if (e.getMessage().equals("No line found")) {
                return null;
            }
            outputView.outputErrorMessage(e);
            return post1stNums(true);
        }
    }

    private WinningNumberDto postBonusNum(WinningNumberDto dto ,boolean isRedo) {
        if (dto == null) {
            return null;
        }
        try {
            return lottoController.postBonusNumber(dto, inputView.inputBonusNum(isRedo));
        } catch (Exception e) {
            if (e.getMessage().equals("No line found")) {
                return null;
            }
            outputView.outputErrorMessage(e);
            return postBonusNum(dto, true);
        }
    }
}
