package lotto.service;

import java.util.List;
import lotto.Utils;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class LottoService {
    private final static int LOTTO_PRICE = 1000;
    private final InputValidator inputValidator;

    public LottoService(InputView inputView, InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getTotalPurchaseNumber(int totalMoney) {
        inputValidator.validateMoney(totalMoney);
        return totalMoney / LOTTO_PRICE;
    }

    public List<Integer> getLottoNumbers(List<String> inputNumbers) {
        inputValidator.validateHasOnlyIntegers(inputNumbers);
        List<Integer> numbers = Utils.convertToIntegers(inputNumbers);

        inputValidator.validateLottoNumber(numbers);

        return numbers;
    }

}
