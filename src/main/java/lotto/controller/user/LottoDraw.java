package lotto.controller.user;

import lotto.exception.LottoNumberException;
import lotto.view.InputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoDraw {
    private final InputView inputView;

    public LottoDraw(InputView inputView) {
        this.inputView = inputView;
    }

    private boolean isCorrectNumber(List<String> inputs) {
        LottoNumberException lottoNumberException = new LottoNumberException();

        try {
            lottoNumberException.checkSixInputs(inputs);   //6개 입력
            lottoNumberException.checkSixNumbers(inputs);  //6개 숫자
            lottoNumberException.checkDuplicate(inputs);   //중복 검사
        } catch (IllegalArgumentException exception) {
            inputView.showInputErrorMessage(exception.getMessage());
            return false;
        }

        return true;
    }

    public void drawLotto () {
        List<String> inputs;

        while (true) {
            inputView.showWinningNumbersInputForm();
            inputs = List.of(readLine().split(","));
            inputView.endInput();

            if (isCorrectNumber(inputs)) {
                break;
            }
        }
    }
}
