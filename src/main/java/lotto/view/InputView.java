package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputValidator inputValidator = new InputValidator();
    private String price;
    private String winnigLotto;
    private Lotto winLotto;
    private String bonusNumber;

    public PurchasePrice inputPrice() {
        price = Console.readLine();

        try {
            inputValidator.checkInteger(price);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputPrice();
        }

        return new PurchasePrice(Integer.parseInt(price));
    }

    public Lotto inputWinLotto() {
        winnigLotto = Console.readLine();

        try {
            inputValidator.checkBlank(winnigLotto);
            inputValidator.checkOnlyNumberAndDelimiterCommaContain(winnigLotto);

            winLotto = new Lotto(parseWinLottoInputAndToList());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputWinLotto();
        }

        return winLotto;
    }

    private List<Integer> parseWinLottoInputAndToList() {
        String[] numbers = winnigLotto.split(",");
        List<Integer> winningNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public int inputBonusNumber() {
        bonusNumber = Console.readLine();
        try {
            inputValidator.checkInteger(bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputBonusNumber();
        }
        return Integer.parseInt(bonusNumber);
    }
}
