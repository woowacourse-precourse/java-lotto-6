package lotto.domain;

public class Validator {

    public Validator() {
    }

    public void validateInteger(String input) {
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }

    public void validatePositiveInteger(int lottoPurchaseCost) {
        if(lottoPurchaseCost<1){
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해야 합니다.");
        }
    }

    public void validateAmountInThousands(int lottoPurchaseCost) {
        if(lottoPurchaseCost%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000의 배수인 정수를 입력해야 합니다.");
        }
    }




}
