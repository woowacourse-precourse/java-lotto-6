package lotto.controller;

import static lotto.validator.InputValidator.checkBonusInput;
import static lotto.validator.InputValidator.checkPriceInput;
import static lotto.validator.InputValidator.checkWinningLottoInput;
import static util.string.StringUtils.parseLottoNumber;
import static util.string.StringUtils.parseStringToInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.View;

public class InputController {

    View view;

    public InputController(View view) {
        this.view = view;
    }

    public int getInputPrice() {
        String inputPrice;
        while (true) {
            view.printRequestPriceMessage();
            inputPrice = readInput();
            try {
                checkPriceInput(inputPrice);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return parseStringToInt(inputPrice);
    }

    public List<Integer> getInputWinningLottoNumbers() {
        String inputWinningLotto;
        while (true) {
            view.printRequestWinningNumbers();
            inputWinningLotto = readInput();
            try {
                checkWinningLottoInput(inputWinningLotto);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return parseLottoNumber(inputWinningLotto);
    }

    public int getInputBonusNumber() {
        String inputBonusNumber;
        while (true) {
            view.printRequestBonusNumber();
            inputBonusNumber = readInput();
            try {
                checkBonusInput(inputBonusNumber);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return parseStringToInt(inputBonusNumber);
    }

    private String readInput() {
        return Console.readLine();
    }

}
