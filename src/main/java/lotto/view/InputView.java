package lotto.view;

import lotto.util.NumberUtil;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return NumberUtil.toInt(readLine());
    }

    public static List<Integer> inputWinningNumber() {
        System.out.printf("%n당첨 번호를 입력해 주세요.%n");

        return NumberUtil.toListInteger(NumberUtil.split(readLine()));
    }

    public static int inputBonusNumber() {
        System.out.printf("%n보너스 번호를 입력해주세요.%n");

        return NumberUtil.toInt(readLine());
    }
}
