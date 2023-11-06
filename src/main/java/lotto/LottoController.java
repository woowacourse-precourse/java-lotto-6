package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Util.checkNumberValidate;
import static lotto.Util.checkTotalPrice;

public class LottoController {

    private Lotto lotto;
    private int totalLottoCnt;

    public void playLotto() {
        start();
        generateLottoNumber();
        middle();
        calculate();
        printEnd();
    }

    private void start() {
        System.out.println("구입금액을 입력해 주세요.");
        this.totalLottoCnt = checkTotalPrice(checkNumberValidate(readLine()));
    }

    private void printEnd() {
    }

    private void calculate() {
    }

    private void middle() {
    }

    private void generateLottoNumber() {
    }



}
