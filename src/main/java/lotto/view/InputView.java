package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.global.util.Validator;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int readLottoPurchaseMoney() {
        outputView.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        Validator.validateIntFormat(amount);

        return Integer.parseInt(amount);
    }

    public List<Integer> readWinningNumbers() {
        outputView.println("당첨 번호를 입력해 주세요.");
        String[] winningNumbers = Console.readLine().split(",");
        Validator.validateIntFormat(winningNumbers);

        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        outputView.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        Validator.validateIntFormat(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}
