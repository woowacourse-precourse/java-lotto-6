package lotto.Lottery.Util;

public class BonusChecker {

    public int isNumber(String bonusNumber){
        try{
            int BonusNumber = Integer.parseInt(bonusNumber);
            return BonusNumber;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력값은 반드시 숫자여야 합니다.");
        }
    }

    public boolean isInRange(int bonusNumber){
        if(bonusNumber < 0 || bonusNumber > 45)
            return false;

        return true;
    }
}
