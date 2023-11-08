package lotto.validation;

import lotto.controller.Controller;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public void checkIsInputNumber(String inputValue) {
        try{
            Integer.parseInt(inputValue);
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력하세요.");

            Input input = new Input();
            Output output = new Output();
            Controller controller = new Controller(input, output);
            controller.lottoGame();
        }

    }
    public void ensureCommaDelimiter(String input) {
        if (input.contains(",") == false) {
//            System.out.println("[ERROR] 번호는 쉼표(,)를 기준으로 구분해주세요. (ex.1,2,3,4,5,6)");
            throw new IllegalArgumentException("[ERROR] 번호는 쉼표(,)를 기준으로 구분해주세요. (ex.1,2,3,4,5,6)");
        }
    }

    public void checkDuplicated(String[] numbers) {
        Set<String> selectedNumbers = new HashSet<>();
        for (String number : numbers) {
            selectedNumbers.add(number);
        }
        if (selectedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요.");
        }
    }

    public void checkNumbersLength(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    public void checkNumbersRange(List<Integer> numbers) {
        numbers.forEach((num) -> {
            checkLottoNumberRange(num);
        });
    }

    public void checkLottoNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 값을 선택하세요.");
        }
    }

    public void isNumber(String[] numbers) {
        try {
            for (int i = 0; i < numbers.length; i++) {
                Integer.parseInt(numbers[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
        }

    }

    public void checkIsBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
        }
    }
}
