package lotto.util;

public class Validator {

    public void validateInputMoneyIsNumber(String inputMoney) {
        try{
            Long.parseLong(inputMoney);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력이 되어져야 합니다!");
        }
    }

    public void validateNumberUnitIsThousand(Long money) {
        try{
            if(money % 1000 !=0)
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다!");
        }

    }
}
