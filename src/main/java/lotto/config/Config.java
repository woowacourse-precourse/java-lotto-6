package lotto.config;

import lotto.game.LottoGame;
import lotto.printer.GamePrinterImpl;
import lotto.scanner.BonusNumberGameScanner;
import lotto.scanner.MoneyGameScanner;
import lotto.scanner.WinningNumbersGameScanner;

public class Config {

    private final LottoGame lottoGame;

    private final GamePrinterImpl printer;
    private final MoneyGameScanner moneyGameScanner;
    private final WinningNumbersGameScanner winningNumbersGameScanner;
    private final BonusNumberGameScanner bonusNumberGameScanner;

    public Config() {
        this.printer = new GamePrinterImpl();
        this.moneyGameScanner = new MoneyGameScanner();
        this.winningNumbersGameScanner = new WinningNumbersGameScanner();
        this.bonusNumberGameScanner = new BonusNumberGameScanner();

        this.lottoGame = new LottoGame(printer, moneyGameScanner, winningNumbersGameScanner, bonusNumberGameScanner);
    }

    public LottoGame getLottoGame() {
        return lottoGame;
    }
}
