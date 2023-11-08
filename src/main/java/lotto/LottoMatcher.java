package lotto;

import lotto.enums.MatchStatus;

public class LottoMatcher {
    public WinningNumber winningNumber;
    public LottoMatcher(WinningNumber winningNumber){
        this.winningNumber = winningNumber;
    }
    public MatchStatus getMatchStatus(Lotto lotto){
        boolean isBonusNumberExist = false;
        int count = 0;
        for(int number: lotto.getNumberListSorted()){
            if(winningNumber.hasNumber(number)){
                count++;
            }
            else if(winningNumber.getBonusNumber() == number){
                isBonusNumberExist = true;
            }
        }
        switch(count){
            case 3:{
                return MatchStatus.CORRESPOND_3;
            }
            case 4:{
                return MatchStatus.CORRESPOND_4;
            }
            case 5:{
                if(isBonusNumberExist){
                    return MatchStatus.CORRESPOND_5_AND_BONUS;
                }
                return MatchStatus.CORRESPOND_5;
            }
            case 6: {
                return MatchStatus.CORRESPOND_6;
            }
            default: return MatchStatus.FAIL;
        }
    }
}
