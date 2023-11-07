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

    private boolean isCorrectNumber(String input) {
        List<String> numbers = List.of(input.split(","));
        LottoNumberException lottoNumberException = new LottoNumberException();

        try {
            lottoNumberException.checkBlank(input);         //빈값 입력
            lottoNumberException.checkEndWithNumber(input); //[1,2,3,4,5,6,] 입력시 예외발생
            lottoNumberException.checkSixInputs(numbers);    //6개 입력
            lottoNumberException.checkSixNumbers(numbers);   //6개 숫자
            lottoNumberException.checkDuplicate(numbers);    //중복 검사
        } catch (IllegalArgumentException exception) {
            inputView.showInputErrorMessage(exception.getMessage());
            return false;
        }

        return true;
    }

    private List<String> inputDrawNumbers() {
        String input;
        List<String> numbers;

        while (true) {
            inputView.showWinningNumbersInputForm();
            input = readLine();
            inputView.endInput();

            if (isCorrectNumber(input)) {
                break;
            }
        }

        numbers = List.of(input.split(","));
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
