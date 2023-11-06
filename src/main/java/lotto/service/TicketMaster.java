package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Customer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class TicketMaster {
    Lotto winningNum;
    int bonusNum;

    public Lotto makeTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public int checkLotto(Lotto lotto) {
        List<Integer> thisLotto = lotto.getNumbers();
        List<Integer> winnerLotto = winningNum.getNumbers();
        int result = 0;
        for (int i = 0; i<winningNum.getNumbers().size(); i++){
            if (winnerLotto.contains(thisLotto.get(i))){
                result++;
            }
        }
        return result;
    }
    public boolean checkLottoBonus(Lotto lotto) {
        List<Integer> thisLotto = lotto.getNumbers();
        return thisLotto.contains(bonusNum);
        }

    public void setWinningNum(Lotto winningNum) {
        this.winningNum = winningNum;
    }

    public void setBonusNum(int bonusNum) {
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateBonusNum(int num) {
        if (winningNum.getNumbers().contains(num)) {
            throw new IllegalArgumentException("보너스 번호가 당첨번호와 중복됩니다.");
        }
    }
}
