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

    public void printNumberBuyLotto() {
        System.out.println(process.tellNumberLotto());
    }

    public void printInformationUserLotto() {
        System.out.println(process.showLottosInformation());
        System.out.println();
    }
}
