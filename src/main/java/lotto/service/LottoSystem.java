package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.type.WinningResultType;
import lotto.model.Lotto;
import lotto.model.Player;

import java.util.List;

public class LottoSystem {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoSystem(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Lotto generateLotto(){

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);

    }

    public WinningResultType checkWinning(Lotto lotto){

        int howMatch = checkMatchCount(lotto);

        if(howMatch<3){
            return WinningResultType.WINNING_RESULT_NOTHING;
        }

        if(howMatch==5&&checkMatchBonus(lotto)){
            return WinningResultType.WINNING_RESULT_5_MATCH_AND_BONUS_MATCH;
        }

        return WinningResultType.values()[howMatch-2];
    }

    public int checkMatchCount(Lotto lotto){

        int checkHowMatchCount = 0;

        for(Integer winningNumber:winningNumbers){
            if(lotto.getNumbers().contains(winningNumber)){
                checkHowMatchCount += 1;
            }
        }

        return checkHowMatchCount;
    }

    public boolean checkMatchBonus(Lotto lotto){

        if(lotto.getNumbers().contains(bonusNumber)){
            return true;
        }
        return false;
    }

    public void giveWinningAccountToPlayer(WinningResultType winningResultType, Player player){
        player.receiveWinningAccount(winningResultType.getWinningPrice());
    }



}
