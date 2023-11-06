package lotto.controller;

import java.math.BigDecimal;
import java.util.Optional;
import lotto.model.LottoSeller;
import lotto.utils.NumberParser;
import lotto.view.InputView;
import lotto.view.OuputView;

public class LottoController {
    private final InputView inputView;
    private final OuputView ouputView;
    private final LottoSeller lottoSeller = new LottoSeller();

    public LottoController(InputView inputView, OuputView ouputView) {
        this.inputView = inputView;
        this.ouputView = ouputView;
    }

    public void run() {
        BigDecimal inputMoney = getInputMoney();

    }

    private BigDecimal getInputMoney() {
        Optional<BigDecimal> generatedInputMoney = generateInputMoney();
        while (generatedInputMoney.isEmpty()) {
            generatedInputMoney = generateInputMoney();
        }
        return generatedInputMoney.get();
    }

    private Optional<BigDecimal> generateInputMoney() {
        try {
            String inputMoney = inputView.insertMoney();
            return NumberParser.parseMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            ouputView.printErrorMessage(errorMessage);
        }
        return Optional.empty();
    }
}
