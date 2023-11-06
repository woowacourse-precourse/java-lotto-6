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
        System.out.println("당첨 번호를 입력해 주세요.");
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
        System.out.println("보너스 번호를 입력해 주세요.");
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
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(process.showStatisticResult());
    }

    public void printRateResult() {
        System.out.println(process.showRateResult());
    }

    public void run() {
        // 로또를 구매한다.
        printBuyLotto();

        // 판매한 로또갯수를 알려준다.
        printNumberBuyLotto();

        // 사용자가 로또의 정보를 보여준다.
        printInformationUserLotto();

        // 게임 호스트가 당첨 번호를 입력한다.
        printPickWinNumbers();

        // 게임 호스트가 보너스 번호를 입력한다.
        printPickBonusNumbers();

        // 사용자가 당첨 통계의 결과를 알려준다.
        printStatisticResult();

        // 사용자가 총수익률을 알려준다.
        printRateResult();
    }
}
