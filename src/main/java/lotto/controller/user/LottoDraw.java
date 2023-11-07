package lotto.controller.user;

import lotto.domain.Lotto;
import lotto.exception.LottoNumberException;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoDraw {
    private Lotto lotto;
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

    private List<String> inputDrawNumbers() {
        List<String> numbers;

        while (true) {
            inputView.showWinningNumbersInputForm();
            numbers = List.of(readLine().split(","));
            inputView.endInput();

            if (isCorrectNumber(numbers)) {
                break;
            }
        }

        return numbers;
    }

    private List<Integer> creatLotto(List<String> numbers) {
        List<Integer> drawNumbers = new ArrayList<>();

        for(String number: numbers) {
            drawNumbers.add(Integer.parseInt(number.trim()));
        }

        return drawNumbers;
    }

    public void draw () {
        List<String> numbers = inputDrawNumbers();
        List<Integer> drawNumbers = creatLotto(numbers);

        lotto = new Lotto(drawNumbers);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
