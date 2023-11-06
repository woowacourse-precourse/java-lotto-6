package lotto.view;

import static lotto.exception.ExceptionMessage.INVALID_BONUS_INPUT;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_INPUT;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.BonusNumberDto;
import lotto.dto.PurchaseAmountDto;
import lotto.dto.WinningNumbersDto;

public class InputParser {

    public static final String SPLIT_DELIMITER = ",";

    public PurchaseAmountDto parsePurchaseAmount(String purchaseAmount) {
        try {
            return new PurchaseAmountDto(Integer.parseInt(purchaseAmount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(INVALID_PURCHASE_AMOUNT.getMessage(), purchaseAmount));
        }
    }

    public WinningNumbersDto parseLottoNumbers(String numbers) {
        try {
            List<Integer> parsedNumbers = Arrays.stream(numbers.split(SPLIT_DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new WinningNumbersDto(parsedNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(INVALID_LOTTO_INPUT.getMessage(), numbers));
        }
    }

    public BonusNumberDto parseBonusNumber(String bonusNumber) {
        try {
            return new BonusNumberDto(Integer.parseInt(bonusNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(INVALID_BONUS_INPUT.getMessage(), bonusNumber));
        }
    }
}
