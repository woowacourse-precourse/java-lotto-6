package lotto.view;

import lotto.util.InputUtil;

import java.util.List;

public class InputView {

    public int inputMoney() {
        System.out.print("구입금액을 입력해 주세요.\n");
        return InputUtil.inputNumber();
    }

    public List<Integer> inputWinningNumber() {
        System.out.println();
        System.out.print("당첨 번호를 입력해 주세요.\n");
        return InputUtil.inputNumbers();
    }

    public int inputBonusNumber() {
        System.out.println();
        System.out.print("보너스 번호를 입력해 주세요.\n");
        return InputUtil.inputNumber();
    }
}
