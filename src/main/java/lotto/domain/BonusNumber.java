package lotto.domain;

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

    private Integer checkForDataType(String userInput){
        try{
            return Integer.parseInt(userInput);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 형식에 맞지 않습니다.");
        }
    }

    private void checkForDuplicates(Integer bonusNumber, MatchNumber matchNumber){
        List<Integer> numbers = matchNumber.getMatchNumbers();

        for (Integer number : numbers) {
            if (number.equals(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 리스트에 중복된 숫자가 있습니다.");
            }
        }
    }

    private void checkLottoNumberInBound(Integer number){
        if (number < START_NUMBER || number > LAST_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
