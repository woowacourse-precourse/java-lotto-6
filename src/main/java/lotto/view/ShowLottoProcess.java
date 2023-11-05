package lotto.view;

import lotto.config.Config;
import lotto.control.Process;

public class ShowLottoProcess {
    private Process process;

    public ShowLottoProcess() {
        this.process = Config.process();
    }

    public void printBuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        process.buyLotto();
        System.out.println();
    }

}
