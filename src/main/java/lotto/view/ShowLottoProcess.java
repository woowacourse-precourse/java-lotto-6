package lotto.view;

import lotto.config.Config;
import lotto.constant.MyConstant;
import lotto.control.Process;

public class ShowLottoProcess {
    private Process process;

    public ShowLottoProcess() {
        this.process = Config.process();
    }

    public void printBuyLotto() {
        System.out.println(MyConstant.MSG_INPUT_MONEY());
        while (true) {
            try {
                process.buyLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

    public void printNumberBuyLotto() {
        System.out.println(process.tellNumberLotto());
    }

    public void printInformationUserLotto() {
        System.out.println(process.showLottosInformation());
        System.out.println();
    }

    public void printPickWinNumbers() {
        System.out.println(MyConstant.MSG_INPUT_WIN_NUMBERS());
        while (true) {
            try {
                process.pickWinNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

    public void printPickBonusNumbers() {
        System.out.println(MyConstant.MSG_INPUT_BONUS_NUMBER());
        while (true) {
            try {
                process.pickBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

    public void printStatisticResult() {
        System.out.println(MyConstant.MSG_START_WIN_STATISTIC());
        System.out.println(MyConstant.MSG_SEPARATOR_DASH());
        System.out.println(process.showStatisticResult());
    }

    public void printRateResult() {
        System.out.println(process.showRateResult());
    }

    public void run() {
        printBuyLotto();

        printNumberBuyLotto();

        printInformationUserLotto();

        printPickWinNumbers();

        printPickBonusNumbers();

        printStatisticResult();

        printRateResult();
    }
}
