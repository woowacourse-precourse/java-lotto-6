package lotto.view;

import static lotto.exception.ExceptionMessage.INVALID_BONUS_INPUT;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_INPUT;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.dto.BonusNumberDto;
import lotto.dto.PurchaseAmountDto;
import lotto.dto.WinningNumbersDto;
import lotto.exception.ExceptionMessage;

public class InputParser {

    public static final String SPLIT_DELIMITER = ",";

    public PurchaseAmountDto parsePurchaseAmount(String purchaseAmount) {
        return parse(purchaseAmount, this::getPurchaseAmountDto, INVALID_PURCHASE_AMOUNT, this::getFormat);
    }

    private PurchaseAmountDto getPurchaseAmountDto(String amount) {
        return new PurchaseAmountDto(Integer.parseInt(amount));
    }

    public WinningNumbersDto parseLottoNumbers(String numbers) {
        return parse(numbers, this::getWinningNumbersDto, INVALID_LOTTO_INPUT, this::getFormat);
    }

    private WinningNumbersDto getWinningNumbersDto(String nums) {
        return new WinningNumbersDto(Arrays.stream(nums.split(SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public BonusNumberDto parseBonusNumber(String bonusNumber) {
        return parse(bonusNumber, this::getBonusNumberDto, INVALID_BONUS_INPUT, this::getFormat);
    }

    private BonusNumberDto getBonusNumberDto(String number) {
        return new BonusNumberDto(Integer.parseInt(number));
    }

    private String getFormat(ExceptionMessage exceptionMessage, String input) {
        return String.format(exceptionMessage.getMessage(), input);
    }

    public <T> T parse(String input, Function<String, T> parsingFunction, ExceptionMessage exceptionMessage,
                       BiFunction<ExceptionMessage, String, String> formatFunction) {
        try {
            return parsingFunction.apply(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(formatFunction.apply(exceptionMessage, input));
        }
    }
}
