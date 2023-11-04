package lotto.verifier;

import lotto.system.Constant;
import lotto.system.ExceptionMessage;

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
                throw new IllegalArgumentException(ExceptionMessage.EACH_NOT_NUMERIC);
            }
        }
    }

    private void checkNumberCount(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != Constant.LOTTO_SIZE ){
            throw new IllegalArgumentException(ExceptionMessage.COUNT_NOT_EQUAL);
        }
    }

    private void checkEachRange(String input) {
        String[] inputs = input.split(",");
        for (String num : inputs) {
            int number = Integer.parseInt(num);
            if (number < Constant.START_INCLUSIVE || number > Constant.END_INCLUSIVE) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
            }
        }
    }

    private void checkDistinct(String input){
        List<Integer> winnerNumbers = new ArrayList<>();
        String[] numbers = input.split(",");
        for(String number : numbers){
            int numberInt = Integer.parseInt(number);
            if (winnerNumbers.contains(numberInt)) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_DISTINCT);
            }
            winnerNumbers.add(numberInt);
        }
    }

}
