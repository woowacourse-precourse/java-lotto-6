package lotto.domain;

import static lotto.util.errorMessage.DATA_TYPE_ERROR;
import static lotto.util.errorMessage.DUPLICATE_ERROR;
import static lotto.util.errorMessage.LOTTO_SIZE_ERROR;
import static lotto.util.errorMessage.OUT_BOUND_ERROR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatchNumber {

    private final List<Integer> matchNumbers;
    private static int START_NUMBER = 1;
    private static int LAST_NUMBER = 45;
    private static String COMMA_DELIMITER = ",";

    public MatchNumber(String userInput){
        this.matchNumbers = validate(userInput);
    }

    public List<Integer> getMatchNumbers() {
        return matchNumbers;
    }

    private List<Integer> validate(String userInput) {
        List<String> inputNumbers = Arrays.asList(userInput.split(COMMA_DELIMITER));
        checkForInputSize(inputNumbers);
        List<Integer> matchNumbers = checkForDataType(inputNumbers);
        checkForDuplicates(matchNumbers);
        checkLottoNumberInBound(matchNumbers);

        return matchNumbers;
    }

    private void checkForInputSize(List<String> inputNumbers){
        if(inputNumbers.size()!=6){
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private List<Integer> checkForDataType(List<String> inputNumbers){
        List<Integer> matchNumbers = new ArrayList<>();
        try{
            for(String inputNumber : inputNumbers){
                matchNumbers.add(Integer.parseInt(inputNumber.trim()));
            }
            return matchNumbers;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(DATA_TYPE_ERROR.getMessage());
        }
    }

    private void checkForDuplicates(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();

        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_ERROR.getMessage());
            }
        }
    }

    private void checkLottoNumberInBound(List<Integer> numbers){
        for (int number : numbers) {
            if (number < START_NUMBER || number > LAST_NUMBER) {
                throw new IllegalArgumentException(OUT_BOUND_ERROR.getMessage());
            }
        }
    }

}
