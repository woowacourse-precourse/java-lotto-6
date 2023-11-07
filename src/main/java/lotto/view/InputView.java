package lotto.view;

import java.util.List;
import lotto.util.io.InputUtil;

public class InputView {

    private InputView() {
    }

    public static int readMoney() {
        System.out.printf("구입금액을 입력해 주세요.%n");
        return InputUtil.readInt();
    }

    public static List<Integer> readLottoNumbers() {
        System.out.printf("%n당첨 번호를 입력해 주세요.%n");
        return InputUtil.readIntegerList();
    }

    public static int readBonusNumber() {
        System.out.printf("%n보너스 번호를 입력해 주세요.%n");
        return InputUtil.readInt();
    }
}
