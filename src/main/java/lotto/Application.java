package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManager lottoManager = new LottoManager();

        System.out.println("구매 금액을 입력해주세요");
        lottoManager.inputCost();

        System.out.println("당첨 번호를 입력해주세요");
        lottoManager.inputWinningNumber();
        lottoManager.checkLotto();

        System.out.println("보너스 번호를 입력해주세요");
        lottoManager.inputBonusNumber();
        lottoManager.checkBonus();

        System.out.println("당첨 통계");
        System.out.println("---");
        lottoManager.checkResult();

    }

}
