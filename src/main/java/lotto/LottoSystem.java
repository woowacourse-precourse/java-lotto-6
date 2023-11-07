package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public LottoSystem(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Lotto generateLotto(List<Integer> newLottoNumbers){

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);

    }

    public WinningResult checkWinning(Lotto lotto){

        int howMatch = checkMatchCount(lotto);

        if(howMatch<3){
            return WinningResult.WINNING_RESULT_NOTHING;
        }

        if(howMatch==5&&checkMatchBonus(lotto)){
            return WinningResult.WINNING_RESULT_5_MATCH_AND_BONUS_MATCH;
        }

        return WinningResult.values()[howMatch-2];
    }

    private int checkMatchCount(Lotto lotto){
        validLottoSystem();
        int checkHowMatchCount = 0;

        for(Integer winningNumber:winningNumbers){
            if(lotto.getNumbers().contains(winningNumber)){
                checkHowMatchCount += 1;
            }
        }
        return checkHowMatchCount;
    }

    private boolean checkMatchBonus(Lotto lotto){
        if(lotto.getNumbers().contains(bonusNumber)){
            return true;
        }
        return false;
    }

    public void giveWinningAccountToPlayer(WinningResult winningResult,Player player){
        player.receiveWinningAccount(winningResult.getWinningPrice());
    }



}
