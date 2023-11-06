package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public Money getInputMoney() {
        System.out.println(REQUEST_INPUT_MONEY);
        String input = Console.readLine();
        System.out.println();
        int money = Integer.parseInt(input);
        return new Money(money);
    }

    public List<Integer> getWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String input = Console.readLine();
        System.out.println();
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        System.out.println();
        return Integer.parseInt(input);
    }
}
