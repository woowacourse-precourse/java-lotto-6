package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.view.contants.InputMessage;
import lotto.view.validation.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class InputView {

    public static double getPurchaseAmount() {
        while (true) {
            System.out.println(InputMessage.PURCHASE_AMOUNT.getValue());
            String inputAmount = Console.readLine();
            try {
                InputValidator.validateBlank(inputAmount);
                InputValidator.validateNumber(inputAmount);
                return Double.parseDouble(inputAmount);
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    public static Lotto getWinningLotto() {
        while (true) {
            try {
                System.out.println(InputMessage.WINNING_LOTTO.getValue());
                String inputWinningLotto = Console.readLine();
                String blankRemoveWinningLotto = inputWinningLotto.replace(" ", "");
                for (String lottoNumber : blankRemoveWinningLotto.split(",", -1)) {
                    InputValidator.validateLottoNumber(lottoNumber);
                }
                return new Lotto(
                        Arrays.stream(blankRemoveWinningLotto.split(","))
                                .map(Integer::parseInt)
                                .toList()
                );
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    public static BonusNumber getBonusNumber() {
        while (true) {
            try {
                System.out.println(InputMessage.BONUS.getValue());
                String inputBonusNumber = Console.readLine();
                InputValidator.validateBlank(inputBonusNumber);
                InputValidator.validateBonusNumber(inputBonusNumber);
                return new BonusNumber(Integer.parseInt(inputBonusNumber.trim()));
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }
}
