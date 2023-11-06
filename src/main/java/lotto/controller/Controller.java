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
        String inputPrice;
        while (true) {
            view.printRequestPriceMessage();
            inputPrice = readInput();
            try {
                InputValidator.checkPriceInput(inputPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return StringUtils.parseNumberOfCount(inputPrice);
    }

    private String readInput() {
        return Console.readLine();
    }
}
