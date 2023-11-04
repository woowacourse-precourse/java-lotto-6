package lotto.manager;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class AwardManager {

    public static List<Award> makeAwards(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber){
        List<Award> awards = new ArrayList<>();
        for(int i=0;i<userLotto.size();i++){
            Lotto eachLotto = userLotto.getIndexAt(i);
            int score = winningLotto.grade(eachLotto);
            awards.add(Award.getByOrdinal(score));
        }
        applyBonusNumber(userLotto,bonusNumber,awards);
        return awards;
    }

    private static void applyBonusNumber(UserLotto userLotto, BonusNumber bonusNumber, List<Award> awards){
        for(int i=0;i<userLotto.size();i++){
            if(awards.get(i).equals(Award.FIVE)) {
                Lotto eachLotto = userLotto.getIndexAt(i);
                if(eachLotto.contains(bonusNumber.getBonusNumber())){
                    awards.set(i,Award.FIVE_BONUS);
                }
            }
        }
    }
}
