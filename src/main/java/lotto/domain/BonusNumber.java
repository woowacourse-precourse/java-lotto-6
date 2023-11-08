package lotto.domain;

import static lotto.util.errorMessage.DATA_TYPE_ERROR;
import static lotto.util.errorMessage.DUPLICATE_ERROR;
import static lotto.util.errorMessage.OUT_BOUND_ERROR;

import java.util.List;

public class BonusNumber {
    private final Integer bonusNumber;
    private static int START_NUMBER = 1;
    private static int LAST_NUMBER = 45;

    public BonusNumber(String userInput, MatchNumber matchNumber){
        int bonusNumber = checkForDataType(userInput);
        checkLottoNumberInBound(bonusNumber);
        checkForDuplicates(bonusNumber,matchNumber);

        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private Integer checkForDataType(String userInput){
        try{
            return Integer.parseInt(userInput);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(DATA_TYPE_ERROR.getMessage());
        }
    }

    private void checkForDuplicates(Integer bonusNumber, MatchNumber matchNumber){
        List<Integer> numbers = matchNumber.getMatchNumbers();

        for (Integer number : numbers) {
            if (number.equals(bonusNumber)) {
                throw new IllegalArgumentException(DUPLICATE_ERROR.getMessage());
            }
        }
    }

    private void checkLottoNumberInBound(Integer number){
        if (number < START_NUMBER || number > LAST_NUMBER) {
            throw new IllegalArgumentException(OUT_BOUND_ERROR.getMessage());
        }
    }
}
