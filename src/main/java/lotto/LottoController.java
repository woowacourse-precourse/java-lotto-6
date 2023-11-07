package lotto;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void play() {
        settingBuyMoney();
        settingLottoNumber();
        settingWinningNumber();
        settingBonusNumber();
        settingLottoResult();
        settingTotalRewardResult();
    }

    private void settingBuyMoney() {
        int inputMoney = inputPlayerBuyMoney();
        lottoService.settingBuyMoney(inputMoney);
        outputView.printLottoTicket(inputMoney);
    }

    private void settingLottoNumber() {
        lottoService.createLottoByInputBuyMoney();
        outputView.printLottoNumbers(lottoService.getLottoNumberStore());
    }

    private void settingWinningNumber() {
        lottoService.settingWinningNumber(inputPlayerWinningNumber());
    }

    private void settingBonusNumber() {
        lottoService.settingBonusNumber(inputPlayerBonusNumber());
    }

    private void settingLottoResult() {
        outputView.printWinningStatus();
        lottoService.resetLottoResultStore();
        lottoService.playerNumberCompareLottoNumber();
        outputView.printLottoMatchResult(lottoService.getLottoResultStore());
    }

    private void settingTotalRewardResult() {
        outputView.printTotalReturn(lottoService.getTotalRewardResult());
    }

    private int inputPlayerBuyMoney() {
        try {
            outputView.printRequestInputBuyMoney();
            String readLottoBuyMoney = inputView.readLottoBuyMoney();
            return lottoService.calculateLottoTicket(readLottoBuyMoney);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return inputPlayerBuyMoney();
        }
    }

    private List<Integer> inputPlayerWinningNumber() {
        try {
            outputView.printRequestInputWinningNumber();
            String readLottoWinningNumber = inputView.readLottoWinningNumber();
            return lottoService.createWinningNumber(readLottoWinningNumber);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return inputPlayerWinningNumber();
        }
    }

    private int inputPlayerBonusNumber() {
        try {
            outputView.printRequestInputBonusNumber();
            String readLottoBonusNumber = inputView.readLottoBonusNumber();
            return lottoService.createBonusNumber(readLottoBonusNumber);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return inputPlayerBonusNumber();
        }
    }
}
