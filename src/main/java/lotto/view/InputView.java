package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.InputValidator;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.PurchaseMoneyValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.ConsoleMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.ConsoleMessage.INPUT_PURCHASE_MONEY;
import static lotto.constant.ConsoleMessage.INPUT_WINNING_LOTTO;

public class InputView {

    private PurchaseMoneyValidator purchaseMoneyValidator = new PurchaseMoneyValidator();
    private LottoNumbersValidator lottoNumbersValidator = new LottoNumbersValidator();
    private BonusNumberValidator bonusNumberValidator;

    public int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);

        String money = processInput(purchaseMoneyValidator);
        return Integer.parseInt(money);
    }

    public Lotto inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO);

        String lotto = processInput(lottoNumbersValidator);
        Lotto winningLotto = convertToLotto(lotto);
        bonusNumberValidator = new BonusNumberValidator(winningLotto);

        return winningLotto;
    }

    private static Lotto convertToLotto(String lotto) {
        lotto = lotto.replaceAll("\\s", "");
        String[] split = lotto.split(",");

        List<Integer> list = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(list);
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);

        String bonusNumber = processInput(bonusNumberValidator);

        return Integer.parseInt(bonusNumber);
    }

    private String processInput(InputValidator inputValidator) {
        while (true) {
            String input = Console.readLine();
            try {
                inputValidator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
