package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.util.UserInputValidator;

public class UserInputOutput {
    public String enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String userPurchase = Console.readLine();
        UserInputValidator.validateNum(userPurchase);

        return userPurchase;
    }

    public String enterWinningNumbers() {
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        UserInputValidator.validateWinningLotto(winningNumbers);

        return winningNumbers;
    }

    public String enterBonusNumber() {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        UserInputValidator.validateNum(bonusNum);

        return bonusNum;
    }

    public void printResultStatistics() {
        System.out.println("\n" + "당첨 통계\n" + "---");
    }


    public void printRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public void printLottoNum(int size) {
        System.out.println("\n" + size + "개를 구매했습니다.");
    }


    public void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printResultLottoCount(String content, int count) {
        System.out.println(content + " - " + count + "개");
    }
}
