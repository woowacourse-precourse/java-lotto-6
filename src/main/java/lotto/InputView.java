package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String MESSAGE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_ENTER_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int purchaseLottoAmount() {
        while (true) {
            try {
                System.out.println(MESSAGE_ENTER_PURCHASE_AMOUNT);
                String input = Console.readLine();
                return InputViewUtil.getValidAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningLotto() {
        System.out.println(MESSAGE_ENTER_WINNING_LOTTO);
        String input = Console.readLine();
        String[] inputSplit = input.split(",");
        List<Integer> winningLotto = new ArrayList<>();
        for (String str : inputSplit) {
            winningLotto.add(Integer.parseInt(str));
        }
        return winningLotto;
    }

    public int readBonusNumber() {
        System.out.println(MESSAGE_ENTER_BONUS_NUMBER);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }


}
