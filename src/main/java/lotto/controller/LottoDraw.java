package lotto.controller;

import lotto.exception.LottoNumberException;
import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoDraw {
    private LottoNumberException lottoNumberException;
    private InputView inputView;

    public LottoDraw(InputView inputView) {
        lottoNumberException = new LottoNumberException();
        this.inputView = inputView;
    }

    private boolean isCorrectAmount(String[] winningNumbers) {
        try {
            lottoNumberException.checkSixInputs(winningNumbers);   //6개 입력
            lottoNumberException.checkSixNumbers(winningNumbers);  //6개 숫자
        } catch (IllegalArgumentException exception) {
            inputView.showInputErrorMessage(exception.getMessage());
            return false;
        }

        return true;
    }

    public void drawLotto () {
        String[] winningNumbers;

        while (true) {
            inputView.showWinningNumbersInputForm();
            winningNumbers = readLine().split(",");
            inputView.endInput();

            if (isCorrectAmount(winningNumbers)) {
                break;
            }
        }
    }
}
