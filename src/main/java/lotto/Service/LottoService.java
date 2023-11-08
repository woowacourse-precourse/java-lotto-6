package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Enum.LottoError;
import lotto.Enum.Prize;
import lotto.Lotto;

import java.util.List;
import java.util.Map;

import static lotto.Enum.constants.*;


public class LottoService {

    public int countingLottoByAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return amount / 1000;
    }

    public List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getNumber(), MAX_LOTTO_NUMBER.getNumber(), LOTTO_NUMBER_COUNT.getNumber());
    }

    public int sameNumberCount(Lotto lotto, Lotto correct) {
        int count = 0;
        for (int number : correct.getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isSameBonusNumber(Lotto lotto, int bonus) {
        return lotto.getNumbers().contains(bonus);
    }


    // 수익률을 구하는 함수
    public String rateOfReturn(int lottoAmount, int winAmount) {
        return String.format("%.1f", ((float) winAmount / (float) lottoAmount * 100f));
    }

    public int prizeAmount(Map<Prize, Integer> winResult) {
        int winAmount = 0;
        for (Prize prize : winResult.keySet()) {
            winAmount += (prize.getMoney() * winResult.get(prize));
        }
        return winAmount;
    }

    public void ValidateBonus(int bonus, Lotto winNumber) {
        if (bonus > MAX_LOTTO_NUMBER.getNumber() || bonus < MIN_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException();
        }
        if (winNumber.getNumbers().contains(bonus)) {
            throw new IllegalStateException(LottoError.BonusFormat.getErrorMessage());
        }
    }
}
