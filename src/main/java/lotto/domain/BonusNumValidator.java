package lotto.domain;

import lotto.util.Constants;

public class BonusNumValidator {
    public static String bonusInput;
    public static int bonusNum;
    public BonusNumValidator(String lottoBonusNum) {
        this.bonusInput = lottoBonusNum;
        bonusNum = Integer.parseInt(lottoBonusNum);
        isRightString();
        isRightSize();
    }
    public void isRightString(){
        if(Constants.nonDigitPattern.matcher(bonusInput).matches()){
            throw new IllegalArgumentException(Constants.NUM_IS_INT);
        }
    }
    public void isRightSize(){
        if(bonusNum<1||bonusNum>45){
            throw new IllegalArgumentException(Constants.NUM_SIZE_ERROR);
        }
    }
}
