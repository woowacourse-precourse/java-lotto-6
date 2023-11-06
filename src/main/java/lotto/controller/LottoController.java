package lotto.controller;

import lotto.service.LottoService;
import lotto.view.ConsoleInputView;

import java.util.*;

public class LottoController {

    private final ConsoleInputView consoleInputView;
    private final LottoService lottoService;

    public LottoController(ConsoleInputView consoleInputView, LottoService lottoService) {
        this.consoleInputView = consoleInputView;
        this.lottoService = lottoService;
    }

    public void lottoGamePlay() {
        consoleInputView.inputBuyLottoAmount();

        String inputUserLottoNumbers = consoleInputView.inputUserLottoNumbers();
        String inputUserBonusNumber = consoleInputView.inputUserBonusNumber();
        Map<String, String> userLottoNumbersAndBonusNumber =
                lottoService.setUserLottoNumbersAndBonusNumber(
                        inputUserLottoNumbers, inputUserBonusNumber
                );
    }



}
