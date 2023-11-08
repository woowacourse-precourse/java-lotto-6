package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);

        System.out.println("\n당첨번호를 입력해주세요.(쉼표(,)로 구분)");

        validateOfLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto() { }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateOfLottoNumbers(List<Integer> numbers) {
        Errors errors = new Errors();

        boolean validInputLottoNumber = false;
        while (!validInputLottoNumber) {
            try {
                errors.checkErrorsOfInputLottoNumbers(numbers);
                validInputLottoNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 숫자만 입력 가능합니다.");
                System.out.println("다시 입력해주세요.");
                numbers.clear();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
                numbers.clear();
            }
        }
    }

}