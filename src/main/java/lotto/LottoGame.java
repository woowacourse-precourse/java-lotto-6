package lotto;

import java.util.List;

import static lotto.UI.*;

public class LottoGame {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumber;
    private int bonusNumber;

    public LottoGame() {
        int money = UI.getMoney();
        this.lottos = publishLottos(money);
        this.winningNumber = UI.getWinningNumber();
        this.bonusNumber = UI.getBonusNumber();
        checkLottos();
    }

    private List<Lotto> publishLottos(int money){
        return null;
    }

    private void checkLottos(){

    }

}
