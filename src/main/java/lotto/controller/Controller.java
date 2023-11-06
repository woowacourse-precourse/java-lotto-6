package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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
        int userPrice = getUserInputPrice();
        List<Integer> winningLottonumbers = getWinningLottonumbers();
        int bonus = getInputBonusNumber();
    }

    private int getInputBonusNumber() {
        String inputNumber;
        while (true) {
            view.printRequestBonusNumber();
            inputNumber = readInput();
            try {
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return StringUtils.parseStringToInt(inputNumber);
    }

    private int getUserInputPrice() {
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
        return StringUtils.parseStringToInt(inputPrice);
    }

    private List<Integer> getWinningLottonumbers() {
        String inputWinningLotto;
        while (true) {
            view.printRequestWinningNumbers();
            inputWinningLotto = readInput();
            try {
                InputValidator.checkWinningLottoInput(inputWinningLotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return StringUtils.parseLottoNumber(inputWinningLotto);

    }

    private String readInput() {
        return Console.readLine();
    }
}
