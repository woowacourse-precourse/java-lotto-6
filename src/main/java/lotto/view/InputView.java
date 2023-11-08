package lotto.view;

import lotto.domain.Lotto;
import lotto.util.NumberUtil;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");

                return NumberUtil.toInt(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumber() {
        while (true) {
            try {
                System.out.printf("%n당첨 번호를 입력해 주세요.%n");

                return NumberUtil.toListInteger(NumberUtil.split(readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                System.out.printf("%n보너스 번호를 입력해주세요.%n");

                int bonusNumber = NumberUtil.toInt(readLine());
                winningNumber.validateContainsBonusInLotto(bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
