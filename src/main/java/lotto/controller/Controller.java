package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import lotto.view.View;
import util.string.StringUtils;
import util.string.validator.InputValidator;

public class Controller {

    LottoService lottoService;
    View view;

    public Controller(LottoService lottoService, View view) {
        this.lottoService = lottoService;
        this.view = view;
    }

    public void play() {
        int userPrice = getUserPrice();
    }

    private int getUserPrice() {
        view.printRequestPriceMessage();
        String inputPrice = readInput();
        InputValidator.checkPriceInput(inputPrice);
        return StringUtils.parseNumberOfCount(inputPrice);
    }

    private String readInput() {
        return Console.readLine();
    }
}
