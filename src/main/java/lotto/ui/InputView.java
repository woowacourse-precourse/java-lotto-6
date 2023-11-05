package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final OutputView outputView = new OutputView();

    public int inputMoney() {

        outputView.enterYourAmount();
        int money = Integer.parseInt(Console.readLine());
        System.out.println();
        return money;
    }

    public int inputBonusNumber() {
        outputView.enterYourBonusNumber();
        int money = Integer.parseInt(Console.readLine());
        System.out.println();
        return money;
    }

    public List<Integer> inputNumbers() {
        String s = Console.readLine();
        return Arrays.stream(s.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
