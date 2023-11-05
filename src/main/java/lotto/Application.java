package lotto;

import lotto.config.Config;
import lotto.view.ShowLottoProcess;

public class Application {
    public static void main(String[] args) {
        ShowLottoProcess showLottoProcess = Config.showLottoProcess();
        showLottoProcess.run();
    }
}
