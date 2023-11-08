package lotto.game;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.LottoGameConsole;

public class LottoGame {
    private int cost = Integer.MIN_VALUE;
    private LottoGame target;
    private List<Lotto> lottos;

    public void init() {
        while (cost == Integer.MIN_VALUE) {
            initCost();
        }
    }

    private void initCost() {
        try {
            cost = LottoGameConsole.readCost();
        } catch (NumberFormatException e) {
            LottoGameConsole.print(LottoGameMessage.NON_NUMBER);
        } catch (IllegalArgumentException e) {
            LottoGameConsole.print(LottoGameMessage.NUMBER_OUT_OF_RANGE);
        }
    }
}
