package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public class GameService {
    public int getMatchedLottoNumber(Lotto myLotto, List<Integer> prizeNumber) {
        int matchedCount = 0;

        for(int lottoNumber : myLotto.getNumbers()) {
            if(prizeNumber.contains(lottoNumber)) matchedCount++;
        }

        return matchedCount;
    }

    public boolean getBonusResult(Lotto myLotto, int bonusNumber) {
        return myLotto.getNumbers().contains(bonusNumber);
    }
}
