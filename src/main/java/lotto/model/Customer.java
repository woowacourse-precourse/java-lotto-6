package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.*;

public class Customer {
    private final int money;
    private List<Lotto> lottos;
    private double rateOfReturn;
    private List<Integer> winningLottos; // [3, 4, 5, 6]
    public Customer(int _money) {
        this.money = _money;
        this.lottos = new ArrayList<Lotto>();
        this.winningLottos = new ArrayList<Integer>();
        initWinningLottos();
    }
    public int getMoney() {
        return money;
    }

    private void initWinningLottos() {
        for(int i = 0 ; i < 5 ; i++) {
            winningLottos.add(0);
        }
    }

    public void buyLotto() {
        lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
    }
    public Lotto getLastLotto() {
        return lottos.get(lottos.size()-1);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void calcWinningLotto(List<Integer> _winning, int _bonusNumber) {
        for (Lotto _lotto: lottos) {
            int same = _lotto.compare(_winning);
            if (same >= 3) {
                winningLottos.set(same -3, winningLottos.get(same -3)+1);
            }
        }
    }

    public void calcRateOfReturn() {

        // 수익금 / 구입 금액 * 100
        rateOfReturn = ((winningLottos.get(0) * THREE_WINNINGS.getLottoConstant())
                + (winningLottos.get(1) * FOUR_WINNINGS.getLottoConstant())
                + (winningLottos.get(2) * FIVE_WINNINGS.getLottoConstant())
                + (winningLottos.get(3) * SIX_WINNINGS.getLottoConstant())
                + (winningLottos.get(4) * FIVE_BONUS_WINNINGS.getLottoConstant())
        ) / (double)money * 100;

        rateOfReturn = Math.round((rateOfReturn * 10)) / 10.0;
    }

    public double getRateOrReturn() {
        return rateOfReturn;
    }

    public List<Integer> getWinningLottos() {
        return winningLottos;
    }
}
