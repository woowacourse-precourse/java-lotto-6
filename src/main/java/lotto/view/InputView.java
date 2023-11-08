package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.system.IOMessage;
import lotto.verifier.BonusNumberVerifier;
import lotto.verifier.MoneyVerifier;
import lotto.verifier.Verifier;
import lotto.verifier.LottoVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {

    private static final Verifier moneyVerifier = new MoneyVerifier();
    private static final Verifier bonusNumVerifier = new BonusNumberVerifier();
    private static final Verifier winnerNumberVerifier = new LottoVerifier();

    private InputView() {

    }

    public static int readMoney() {
        while (true) {
            try {
                OutputView.printMessage(IOMessage.READ_MONEY_MESSAGE);
                String input = Console.readLine();
                moneyVerifier.check(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }

    }

    public static List<Integer> readWinnerNumber() {
        while (true) {
            try {
                OutputView.printEmptyLine();
                OutputView.printMessage(IOMessage.READ_WINNING_NUM_MESSAGE);
                String input = Console.readLine();
                winnerNumberVerifier.check(input);

                return Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    public static Integer readBonusNumber() {
        while (true) {
            try {
                OutputView.printEmptyLine();
                OutputView.printMessage(IOMessage.READ_BONUS_NUM_MESSAGE);
                String input = Console.readLine();
                bonusNumVerifier.check(input);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }


}
