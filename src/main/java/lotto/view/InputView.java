package lotto.view;

import lotto.util.InputUtil;

public class InputView {

    public int inputMoney() {
        System.out.print("구입금액을 입력해 주세요.\n");
        return InputUtil.inputNumber();
    }
}
