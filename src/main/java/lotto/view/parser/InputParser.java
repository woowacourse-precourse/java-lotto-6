package lotto.view.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.constant.InputConstant;
import lotto.view.validator.BonusNumberInputValidator;
import lotto.view.validator.UserMoneyInputValidator;
import lotto.view.validator.WinningLottoNumbersInputValidator;

public class InputParser {
    private final UserMoneyInputValidator userMoneyInputValidator;
    private final WinningLottoNumbersInputValidator winningLottoNumbersInputValidator;
    private final BonusNumberInputValidator bonusNumberInputValidator;

    public InputParser() {
        userMoneyInputValidator = new UserMoneyInputValidator();
        winningLottoNumbersInputValidator = new WinningLottoNumbersInputValidator();
        bonusNumberInputValidator = new BonusNumberInputValidator();
    }

    public Long parseUserMoney(String userMoney) {
        userMoney = removeBlank(userMoney);
        userMoneyInputValidator.validate(userMoney);
        return parseToLong(userMoney);
    }

    public List<Integer> parseWinningLottoNumbers(String winningLottoNumbers) {
        winningLottoNumbers = removeBlankInEachSeperatedItems(winningLottoNumbers);
        winningLottoNumbersInputValidator.validate(winningLottoNumbers);
        return parseToIntegers(winningLottoNumbers);
    }

    public Integer parseBonusNumber(String bonusNumber) {
        bonusNumber = removeBlank(bonusNumber);
        bonusNumberInputValidator.validate(bonusNumber);
        return parseToInteger(bonusNumber);
    }

    private String removeBlank(String userInput) {
        if (userInput.contains(InputConstant.BLANK_SYMBOL)) {
            userInput = userInput.replace(InputConstant.BLANK_SYMBOL, InputConstant.VOID_SYMBOL);
        }
        return userInput;
    }

    private String removeBlankInEachSeperatedItems(final String winningLottoNumbers) {
        return Arrays.stream(splitItemsWithDelimiter(winningLottoNumbers))
                .map(this::removeBlank)
                .collect(Collectors.joining(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER));
    }

    private Long parseToLong(final String userInput) {
        return Long.parseLong(userInput);
    }

    private Integer parseToInteger(final String userInput) {
        return Integer.parseInt(userInput);
    }

    private List<Integer> parseToIntegers(final String userInput) {
        return Arrays.stream(splitItemsWithDelimiter(userInput))
                .map(Integer::parseInt)
                .toList();
    }

    private String[] splitItemsWithDelimiter(final String userInput) {
        return userInput.split(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER);
    }
}