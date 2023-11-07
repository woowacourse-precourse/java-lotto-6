package lotto.domain;

public class Validator {

    public Validator() {
    }

    public void validateInteger(String input) {
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
    }

    public void validatePositiveInteger(int lottoPurchaseCost) {
    }

    public void validateAmountInThousands(int lottoPurchaseCost) {
    }




}
