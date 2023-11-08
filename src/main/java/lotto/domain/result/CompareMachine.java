package lotto.domain.result;

import static lotto.option.GameOption.FIVE_AND_BONUS_MONEY;
import static lotto.option.GameOption.FIVE_MONEY;
import static lotto.option.GameOption.FOUR_MONEY;
import static lotto.option.GameOption.LOTTO_PRICE;
import static lotto.option.GameOption.SIX_MONEY;
import static lotto.option.GameOption.THREE_MONEY;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.user.UserLotto;
import lotto.domain.win.WinLotto;
import lotto.generator.LottoResultGenerator;
import lotto.option.EqualStatus;

public class CompareMachine {
    private static final int PERCENTAGE = 100;
    private final Map<LottoResult, Integer> winStatus = new HashMap<>();

    public CompareMachine() {
        winStatus.put(new LottoResult(EqualStatus.THREE_EQUAL), 0);
        winStatus.put(new LottoResult(EqualStatus.FOUR_EQUAL), 0);
        winStatus.put(new LottoResult(EqualStatus.FIVE_EQUAL), 0);
        winStatus.put(new LottoResult(EqualStatus.FIVE_AND_BONUS_EQUAL), 0);
        winStatus.put(new LottoResult(EqualStatus.SIX_EQUAL), 0);
    }

    public void compare(UserLotto userLotto, WinLotto winLotto) {
        int equalCount;
        int bonusCount;
        for (int i = 0; i < userLotto.size(); i++) {
            equalCount = winLotto.countEqual(userLotto.indexOf(i));
            bonusCount = winLotto.countBonus(userLotto.indexOf(i));
            referee(equalCount, bonusCount);
        }
    }

    private void referee(int equalCount, int bonusCount) {
        LottoResult lottoResult = LottoResultGenerator.setEqualStatus(equalCount, bonusCount);
        if (winStatus.containsKey(lottoResult)) {
            winStatus.put(lottoResult, (winStatus.get(lottoResult)) + 1);
        }
    }

    public double calculateRate(UserLotto userLotto) {
        double moneyGet = winStatus.get(new LottoResult(EqualStatus.THREE_EQUAL)) * THREE_MONEY.getNumber()
                + winStatus.get(new LottoResult(EqualStatus.FOUR_EQUAL)) * FOUR_MONEY.getNumber()
                + winStatus.get(new LottoResult(EqualStatus.FIVE_EQUAL)) * FIVE_MONEY.getNumber()
                + winStatus.get(new LottoResult(EqualStatus.FIVE_AND_BONUS_EQUAL)) * FIVE_AND_BONUS_MONEY.getNumber()
                + winStatus.get(new LottoResult(EqualStatus.SIX_EQUAL)) * SIX_MONEY.getNumber();
        double moneyUse = LOTTO_PRICE.getNumber() * userLotto.size();
        return (moneyGet / moneyUse) * PERCENTAGE;
    }

    public Map<LottoResult, Integer> getWinStatus() {
        return winStatus;
    }
}
