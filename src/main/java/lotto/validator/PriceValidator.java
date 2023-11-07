package lotto.validator;

import lotto.utils.ErrorCode;

public class PriceValidator {
        public void checkBlank(String input){
                if(input.isEmpty()) throw new IllegalArgumentException(ErrorCode.INVALID_MONEY.getMessage());
        }

        public void checkNumber(String input){
                if(input.matches("[^0-9]*")) throw new IllegalArgumentException(ErrorCode.INVALID_MONEY.getMessage());
        }

        public void checkWon(String input){
                long money = Long.parseLong(input);
                if(money%1000!=0) throw new IllegalArgumentException(ErrorCode.INVALID_MONEY.getMessage());
        }
}
