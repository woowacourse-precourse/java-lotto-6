package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoChecker {
    public boolean checkLottoNumberRange(List<Integer> lottoNumber, int min, int max) {
        for (int i = 0; i < lottoNumber.size(); i++) {
            if (lottoNumber.get(i) < min || lottoNumber.get(i) > max) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicateLottoNumber(List<Integer> lottoNumber) {
        if (lottoNumber.size() != lottoNumber.stream().distinct().count()) {
            return false;
        }
        return true;
    }

    public boolean checkBonusNumberRange(int bonusNumber, int min, int max) {
        if (bonusNumber < min || bonusNumber > max) {
            return false;
        }
        return true;
    }

    public boolean checkDuplicateBonusNumber(List<Integer> lottoNumber, int bonusNumber) {
        for (int nowNumber : lottoNumber) {
            if (nowNumber == bonusNumber) {
                return false;
            }
        }
        return true;
    }

    public int compare(Lotto purchaseLotto, Lotto winningLotto) {
        int count = 0;

        for (int i = 0; i < Lotto.NUMBER_OF_MEMBERS; i++) {
            if (purchaseLotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> compareLottoTickets(List<Lotto> purchaseLottoTickets, Lotto winningLotto, int bonusNumber) {
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < purchaseLottoTickets.size(); i++) {
            int count = compare(purchaseLottoTickets.get(i), winningLotto);
            if (count == Prize.THIRD.getMatchCount() && includeBonusNumberInLottoNumber(purchaseLottoTickets.get(i), bonusNumber)) {
                count = Prize.SECOND.getMatchCount();
            }
            counts.add(count);
        }

        return counts;
    }

    public boolean includeBonusNumberInLottoNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public List<Integer> lottoResult(List<Integer> counts) {
        List<Integer> result = new ArrayList<>();
        for (Prize prize : Prize.values()) {
            result.add(Collections.frequency(counts, prize.getMatchCount()));
        }
        return result;
    }
}
