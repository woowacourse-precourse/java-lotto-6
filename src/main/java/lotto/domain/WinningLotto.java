package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.constants.Constants;

public class WinningLotto {
    private List<Integer> winninglottos = new ArrayList<>(Constants.SIX);
    private Integer bonusNumber;


    public WinningLotto(List<Integer> winninglottos, Integer bonusNumber) {
        this.winninglottos = winninglottos;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinninglottos() {
        return winninglottos;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void compareLottos(Customer customer, WinningLotto winningNumber) {
        EnumMap<Reward, Integer> prizes = customer.getPrizes();
        for (Lotto lotto : customer.getLottos()) {
            Reward reward = checkRewardBonusOrNot(winningNumber, lotto);
            prizes.put(reward, prizes.getOrDefault(reward, Constants.ZERO) + Constants.ONE);
        }
    }

    public int compareOneLottoAndWinningLotto(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.getLottosNumber().contains(winningNumber)) {
                count += Constants.ONE;
            }
        }
        return count;
    }
    public boolean compareWithBonusNumber(Lotto lotto, int bonusNumber){
        return lotto.getLottosNumber().contains(bonusNumber);
    }
    public Reward checkRewardBonusOrNot(WinningLotto winningLotto, Lotto lotto){

        int count = compareOneLottoAndWinningLotto(lotto, winningLotto.getWinninglottos());
        boolean hasBonusNumber = compareWithBonusNumber(lotto, winningLotto.getBonusNumber());
        Reward reward = Reward.values()[count];
        if(reward == Reward.MATCH_FIVE_NOT_BONUS && hasBonusNumber){
            return  Reward.MATCH_FIVE_BONUS;
        }return reward;
    }
}
