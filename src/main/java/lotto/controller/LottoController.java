package lotto.controller;

import lotto.service.LottoService;
import lotto.view.ConsoleInputView;

public class LottoController {

    private final ConsoleInputView consoleInputView;
    private final LottoService lottoService;

    public LottoController(ConsoleInputView consoleInputView, LottoService lottoService) {
        this.consoleInputView = consoleInputView;
        this.lottoService = lottoService;
    }

    public void lottoGamePlay() {
        buyLottoTickets();

        String inputUserLottoNumbers = consoleInputView.inputUserLottoNumbers();
        lottoService.userLottoNumbersValidate(inputUserLottoNumbers);

        String inputUserBonusNumber = consoleInputView.inputUserBonusNumber();
        lottoService.userBonusNumberValidate(inputUserLottoNumbers, inputUserBonusNumber);

        /*Map<String, String> userLottoNumbersAndBonusNumber =
                lottoService.setUserLottoNumbersAndBonusNumber(
                        inputUserLottoNumbers, inputUserBonusNumber
                );*/
    }

    public void buyLottoTickets() {
        while (true) {
            try {
                String inputBuyLottoAmount = consoleInputView.inputBuyLottoAmount();
                lottoService.buyLottoAmountValidate(inputBuyLottoAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
