package lotto;

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
}
