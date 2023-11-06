package lotto;

import lotto.App.LottoApp;
import lotto.App.LottoConsole;
import lotto.App.LottoView;

public class Application {

    public static void main(String[] args) {
        LottoApp lottoApp = new LottoApp(new LottoConsole(), new LottoView());
        lottoApp.run();
    }
}
