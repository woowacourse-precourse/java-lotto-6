package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validate.AmountValidator;
import lotto.validate.LottoValidator;

public class InputView {
    private final AmountValidator amountValidator = new AmountValidator();
    private final LottoValidator lottoValidator = new LottoValidator();
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final String COMMA = ",";


    public int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        amountValidator.validate(amount);
        return Integer.parseInt(amount);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] splitNumber = Console.readLine().replaceAll(SPACE, NO_SPACE).split(COMMA);
        for(String number : splitNumber) {
            lottoValidator.validate(number);
        }
        return Arrays.stream(splitNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String number = Console.readLine();
        lottoValidator.validate(number);
        return Integer.parseInt(number);
    }
}
