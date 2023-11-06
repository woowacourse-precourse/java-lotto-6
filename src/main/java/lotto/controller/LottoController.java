package lotto.controller;

import lotto.view.ConsoleInputView;

import java.util.*;

public class LottoController {

    private final ConsoleInputView consoleInputView;

    public LottoController(ConsoleInputView consoleInputView) {
        this.consoleInputView = consoleInputView;
    }

    public void lottoGamePlay() {
        consoleInputView.inputBuyLottoAmount();
        Map<String, String> userLottoNumbersAndBonusNumber = setUserLottoNumbersAndBonusNumber();
        System.out.println("userLottoNumbersAndBonusNumber.toString() = " + userLottoNumbersAndBonusNumber.toString());
    }

    public Map<String, String> setUserLottoNumbersAndBonusNumber() {

        Map<String, String> userLottoNumbersAndBonusNumber = new HashMap<>();

        String inputUserLottoNumbers = consoleInputView.inputUserLottoNumbers();
        String inputUserBonusNumber = consoleInputView.inputUserBonusNumber();

        userLottoNumbersAndBonusNumber.put("userLottoNumbers", inputUserLottoNumbers);
        userLottoNumbersAndBonusNumber.put("userBonusNumber", inputUserBonusNumber);

        return userLottoNumbersAndBonusNumber;
    }

}
