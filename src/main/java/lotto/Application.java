package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = new LottoGame();

        int buy = lottoGame.buyLotto();

        List<Lotto> draws = new ArrayList<>();
        for (int i = 0; i < buy; i++) {
            draws.add(lottoGame.drawLotto());
        }

        Lotto win = lottoGame.inputWinningNumbers();
        int bonus = lottoGame.inputBonusNumber(win);

        int[] winningResult = lottoGame.winningResult(draws, win, bonus);
        LottoGame.winningStats(winningResult);
        LottoGame.rateOfReturn(winningResult, buy);
    }
}
