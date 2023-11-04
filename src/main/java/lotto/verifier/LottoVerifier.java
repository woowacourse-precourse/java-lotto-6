package lotto.verifier;

import java.util.ArrayList;
import java.util.List;

public class LottoVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumberCount(input);
        checkEachNumeric(input);
        checkEachRange(input);
        checkDistinct(input);
    }

    private void checkEachNumeric(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 입력된 값은 숫자가 아닙니다.");
            }
        }
    }

    private void checkNumberCount(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개의 숫자가 아닙니다.");
        }
    }

    private void checkEachRange(String input) {
        String[] inputs = input.split(",");
        for (String num : inputs) {
            int number = Integer.parseInt(num);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또번호는 1~45사이의 숫자이어야 합니다.");
            }
        }
    }

    private void checkDistinct(String input){
        List<Integer> winnerNumbers = new ArrayList<>();
        String[] numbers = input.split(",");
        for(String number : numbers){
            int numberInt = Integer.parseInt(number);
            if (winnerNumbers.contains(numberInt)) {
                throw new IllegalArgumentException("[ERROR] 중복된 로또 번호입니다.");
            }
            winnerNumbers.add(numberInt);
        }
    }

}
