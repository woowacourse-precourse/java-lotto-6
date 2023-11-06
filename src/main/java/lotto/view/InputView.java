package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputValidator inputValidator = new InputValidator();

    public PurchasePrice inputPrice() {
        String price = Console.readLine();
        inputValidator.checkInteger(price);
        return new PurchasePrice(Integer.parseInt(price));
    }

    public Lotto inputWinLotto() {
        String winnigLotto = Console.readLine();

        inputValidator.checkBlank(winnigLotto);
        inputValidator.checkOnlyNumberAndDelimiterCommaContain(winnigLotto);

        String[] numbers = winnigLotto.split(",");
        List<Integer> winningNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(winningNumbers);
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        inputValidator.checkInteger(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
