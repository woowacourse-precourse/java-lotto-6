package lotto.view;

import lotto.config.Config;
import lotto.constant.MyConstant;
import lotto.control.Process;
import lotto.utill.Output;

public class ShowLottoProcess {
    private Process process;

    public ShowLottoProcess() {
        this.process = Config.process();
    }

    public void printBuyLotto() {
        Output.printMsg(MyConstant.MSG_INPUT_MONEY());
        while (true) {
            try {
                process.buyLotto();
                break;
            } catch (IllegalArgumentException e) {
                Output.printMsg(e.getMessage());
            }
        }
        Output.printNewLine();
    }

    public void printNumberBuyLotto() {
        Output.printMsg(process.tellNumberLotto());
    }

    public void printInformationUserLotto() {
        Output.printMsg(process.showLottosInformation());
        Output.printNewLine();
    }

    public void printPickWinNumbers() {
        Output.printMsg(MyConstant.MSG_INPUT_WIN_NUMBERS());
        while (true) {
            try {
                process.pickWinNumber();
                break;
            } catch (IllegalArgumentException e) {
                Output.printMsg(e.getMessage());
            }
        }
        Output.printNewLine();
    }

    public void printPickBonusNumbers() {
        Output.printMsg(MyConstant.MSG_INPUT_BONUS_NUMBER());
        while (true) {
            try {
                process.pickBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                Output.printMsg(e.getMessage());
            }
        }
        Output.printNewLine();
    }

    public void printStatisticResult() {
        Output.printMsg(MyConstant.MSG_START_WIN_STATISTIC());
        Output.printMsg(MyConstant.MSG_SEPARATOR_DASH());
        Output.printMsg(process.showStatisticResult());
    }

    public void printRateResult() {
        Output.printMsg(process.showRateResult());
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
