package lotto.Lotto;

import lotto.Print.ErrorMessage;

public class WinningLotto {

    private final Lotto numbers;
    private final int bonusNumber;

    public WinningLotto(Lotto numbers, int bonusNumber){
        validate(numbers, bonusNumber);
        this.numbers=numbers;
        this.bonusNumber=bonusNumber;
    }

    private void validate(Lotto numbers, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateNumber(numbers,bonusNumber);
    }

    private void validateNumberRange(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(ErrorMessage.INAVLID_LOTTO_NUMBER_RANGE);
        }
    }

    private void validateDuplicateNumber(Lotto numbers, int bonusNumber){
        if(numbers.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE);
        }
    }

    public Lotto getLotto(){
        return numbers;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }

}