package lotto.Lottery.Util;

public class CostChecker {

    final static int LOTTO_PRICE = 1000;

    // 금액이 음수인 경우
    public boolean isPositive(int Cost){
        if(Cost <= 0)
            return false;
        return true;
    }

    // 금액이 1000원 단위로 떨어지지 않는 경우
    public boolean isDivisionWithThousand(int Cost){
        if(Cost > 0 && Cost % LOTTO_PRICE == 0)
            return true;
        return false;
    }

    // 숫자가 아닌 값을 입력한 경우
    public int isNumber(String Cost){
        int userMoney;
        try{
            userMoney = Integer.parseInt(Cost);
            return userMoney;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닌 값입니다.");
        }

    }

    public void CostCheck(int userMoney){
        if(isPositive(userMoney) == false)
            throw new IllegalArgumentException("[ERROR] 음수가 아닌 값을 입력할 수 없습니다.");

        if(isDivisionWithThousand(userMoney) == false)
            throw new IllegalArgumentException("[ERROR] 입력 금액은 반드시 1000원 단위로만 주문 가능합니다.");
    }

}
