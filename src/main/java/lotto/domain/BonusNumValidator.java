package lotto.domain;

import lotto.util.Constants;

public class BonusNumValidator {
    public static String BONUSSTRING;
    public static int BONUS;
    public BonusNumValidator(String lottoBonusNum) {
        this.BONUSSTRING = lottoBonusNum;
        BONUS = Integer.parseInt(lottoBonusNum);
        isInt(lottoBonusNum);
    }
    public void isRightString(){
        if(Constants.nonDigitPattern.matcher(BONUSSTRING).matches()){
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }

    }
    public void isInt(String lottoBonusNum){
        if(BONUS<1||BONUS>45){
            throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45까지이다.");
        }
    }
}
