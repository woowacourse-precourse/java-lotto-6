package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<Integer> lottoMatch = new ArrayList<>();
    List<Boolean> hasBonusMatch = new ArrayList<>();

    public Result(List<Integer> winningLotto, List<List<Integer>> userLottoNumbers, int bonus) {
        for (List<Integer> userLottoNumber: userLottoNumbers) {
            lottoMatch.add(compareLottoNumber(winningLotto,userLottoNumber));
            hasBonusMatch.add(checkBonusNumber(userLottoNumber,bonus));
        }
    }

    private int compareLottoNumber(List<Integer> winningLotto, List<Integer> userLottoNumber) {
        int match = 0;
        for (int lottoNumber: userLottoNumber) {
            match += checkLottoNumberMatch(winningLotto, lottoNumber);
        }
        return match;
    }

    private int checkLottoNumberMatch(List<Integer> winningLotto, int lottoNumber) {

        if (winningLotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusNumber(List<Integer> winningLotto, int bonus) {
        if(winningLotto.contains(bonus)) {
            return true;
        }
        return false;
    }

    public List<Integer> getLottoMatch() {
        return lottoMatch;
    }

    public List<Boolean> getHasBonusMatch() {
        return hasBonusMatch;
    }
}
