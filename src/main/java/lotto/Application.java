//Application.java
package lotto;

import lotto.Controller.Game;
import lotto.Controller.LottoGenerator;
import lotto.Controller.WinningCalculator;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        WinningCalculator winningCalculator = new WinningCalculator();
        Game lottoGame = new Game(lottoGenerator, winningCalculator);

        lottoGame.run();
    }
}
