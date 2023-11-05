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
        if(money % 1000 !=0)
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다!");
    }

    public void validateNumberNegativeOrZero(Long money) {
        if(money <= 0)
            throw new IllegalArgumentException("[ERROR] 금액은 음수가 아니라 양수여야 합니다!");
    }
}
