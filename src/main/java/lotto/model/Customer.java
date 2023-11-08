package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static lotto.constant.LottoConstant.*;

public class Customer {
    private final Money money;
    private List<Lotto> lottos;
    private double rateOfReturn;
    private List<Integer> winningLottos; // [3, 4, 5, 6]
    public Customer(String money) {
        validationMoney(money);
        this.money = new Money(parseInt(money));
        this.lottos = new ArrayList<Lotto>();
        this.winningLottos = new ArrayList<Integer>();
        initWinningLottos();
    }

    private void validationMoney(String money) {
        try {
            parseInt(money);
        } catch (NumberFormatException error) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage()+ErrorMessage.INPUT.getMessage());
        }
    }
    public int getMoney() {
        return money.getValue();
    }

    private void initWinningLottos() {
        for(int i = 0 ; i < 5 ; i++) {
            winningLottos.add(0);
        }
    }

    public void buyLotto() {
        try {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(RANGE_START.getNumber(), RANGE_END.getNumber(), LOTTO_SIZE.getNumber());
            lottos.add(new Lotto(lotto));
        } catch (IllegalArgumentException error) {
            buyLotto();
        }

    }
    public Lotto getLastLotto() {
        return lottos.get(lottos.size()-1);
    }

    public void throwLastLotto() {
        lottos.remove(lottos.size() -1);
    }

    public int getLottosSize() {
        return lottos.size();
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
        rateOfReturn = ((winningLottos.get(0) * THREE_WINNINGS.getNumber())
                + (winningLottos.get(1) * FOUR_WINNINGS.getNumber())
                + (winningLottos.get(2) * FIVE_WINNINGS.getNumber())
                + (winningLottos.get(3) * SIX_WINNINGS.getNumber())
                + (winningLottos.get(4) * FIVE_BONUS_WINNINGS.getNumber())
        ) / (double)money.getValue() * 100;

        rateOfReturn = Math.round((rateOfReturn * 10)) / 10.0;
    }

    public double getRateOrReturn() {
        return rateOfReturn;
    }

    public List<Integer> getWinningLottos() {
        return winningLottos;
    }
}
