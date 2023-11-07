package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.validate.AmountValidator;
import lotto.validate.BonusValidator;
import lotto.validate.WinningLottoValidator;

public class InputView {
    private final WinningLottoValidator winningLottoValidator = new WinningLottoValidator();
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";

    public int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        new AmountValidator().validate(amount);
        return Integer.parseInt(amount);
    }

    public Lotto inputWinningLotto() {
        System.out.println(NEW_LINE + "당첨 번호를 입력해 주세요.");
        String[] WinningNumber = Console.readLine().replaceAll(SPACE, NO_SPACE).split(COMMA);
        ValidateWinningNumber(WinningNumber);
        return new Lotto(
                Arrays.stream(WinningNumber)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

    public void ValidateWinningNumber(String[] Number) {
        if (Number.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 숫자를 입력해 주세요.");
        }
        for (String number : Number) {
            winningLottoValidator.validate(number);
        }
    }

    public int inputBonusNumber() {
        System.out.println(NEW_LINE + "보너스 번호를 입력해 주세요.");
        String number = Console.readLine();
        new BonusValidator().validate(number);
        return Integer.parseInt(number);
    }
}
