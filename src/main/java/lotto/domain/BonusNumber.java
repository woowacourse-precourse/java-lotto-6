package lotto.domain;


import lotto.Constants;

public class BonusNumber {
        private final int bonusNumber;
        public BonusNumber(int bonusNumber) {
                validate(bonusNumber);
                this.bonusNumber = bonusNumber;
        }
        private void validate(int bonusNumber) {
                if(bonusNumber< Constants.LOTTO_MIN_NUMBER){
                        throw new IllegalArgumentException();
                }
                if(bonusNumber>Constants.LOTTO_MAX_NUMBER){
                        throw new IllegalArgumentException();
                }
        }
}
