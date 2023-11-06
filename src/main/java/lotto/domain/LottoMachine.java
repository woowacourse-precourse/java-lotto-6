package lotto.domain;

import static lotto.Option.GameOption.FIVE_AND_BONUS_MONEY;
import static lotto.Option.GameOption.FIVE_MONEY;
import static lotto.Option.GameOption.FOUR_MONEY;
import static lotto.Option.GameOption.LOTTO_PRICE;
import static lotto.Option.GameOption.SIX_MONEY;
import static lotto.Option.GameOption.THREE_MONEY;

import java.util.HashMap;
import java.util.Map;
import lotto.Option.GameStatus;
import lotto.domain.user.UserLotto;
import lotto.domain.win.WinLotto;

public class LottoMachine {
    private final Map<LottoResult, Integer> winStatus = new HashMap<>();

    public LottoMachine() {
        winStatus.put(new LottoResult(GameStatus.THREE_EQUAL), 0);
        winStatus.put(new LottoResult(GameStatus.FOUR_EQUAL), 0);
        winStatus.put(new LottoResult(GameStatus.FIVE_EQUAL), 0);
        winStatus.put(new LottoResult(GameStatus.FIVE_AND_BONUS_EQUAL), 0);
        winStatus.put(new LottoResult(GameStatus.SIX_EQUAL), 0);
    }

    public void compare(UserLotto userLotto, WinLotto winLotto) {
        int equalCount;
        int bonusCount;
        for (int i = 0; i < userLotto.getLottos().size(); i++) {
            equalCount = winLotto.isEqual(userLotto.getLottos().get(i));
            bonusCount = winLotto.isBonus(userLotto.getLottos().get(i));
            referee(equalCount, bonusCount);
        }
    }

    public void referee(int equalCount, int bonusCount) {
        LottoResult lottoResult = new LottoResult(equalCount, bonusCount);
        if (winStatus.containsKey(lottoResult)) {
            winStatus.put(lottoResult, (winStatus.get(lottoResult)) + 1);
        }
    }

    public double calculateRate(UserLotto userLotto) {
        double moneyGet = winStatus.get(new LottoResult(GameStatus.THREE_EQUAL)) * THREE_MONEY.getNumber()
                + winStatus.get(new LottoResult(GameStatus.FOUR_EQUAL)) * FOUR_MONEY.getNumber()
                + winStatus.get(new LottoResult(GameStatus.FIVE_EQUAL)) * FIVE_MONEY.getNumber()
                + winStatus.get(new LottoResult(GameStatus.FIVE_AND_BONUS_EQUAL)) * FIVE_AND_BONUS_MONEY.getNumber()
                + winStatus.get(new LottoResult(GameStatus.SIX_EQUAL)) * SIX_MONEY.getNumber();
        double moneyUse = LOTTO_PRICE.getNumber() * userLotto.getLottos().size();
        return (moneyGet / moneyUse) * 100;
    }

    public Map<LottoResult, Integer> getWinStatus() {
        return winStatus;
    }
}
