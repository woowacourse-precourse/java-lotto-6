package lotto.view;

import lotto.util.NumberUtil;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputBuyMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return NumberUtil.toInt(readLine());
    }

    public static List<Integer> inputDrawingNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");

        return NumberUtil.toListInteger(NumberUtil.split(readLine()));
    }
}
