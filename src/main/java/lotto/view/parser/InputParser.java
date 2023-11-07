package lotto.view.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.constant.InputConstant;
import lotto.view.validator.BonusNumberValidator;
import lotto.view.validator.UserMoneyInputValidator;
import lotto.view.validator.WinningLottoNumbersInputValidator;

public class InputParser {
    private final UserMoneyInputValidator userMoneyInputValidator;
    private final WinningLottoNumbersInputValidator winningLottoNumbersInputValidator;
    private final BonusNumberValidator bonusNumberValidator;

    public InputParser() {
        userMoneyInputValidator = new UserMoneyInputValidator();
        winningLottoNumbersInputValidator = new WinningLottoNumbersInputValidator();
        bonusNumberValidator = new BonusNumberValidator();
    }

    public Long parseUserMoney(String userMoney) {
        userMoney = removeBlank(userMoney);
        userMoneyInputValidator.validate(userMoney);
        return parseToLong(userMoney);
    }

    public List<Long> parseWinningLottoNumbers(String winningLottoNumbers) {
        winningLottoNumbers = removeBlankInEachSeperatedItems(winningLottoNumbers);
        winningLottoNumbersInputValidator.validate(winningLottoNumbers);
        return parseToLongList(winningLottoNumbers);
    }

    public Long parseBonusNumber(String bonusNumber) {
        bonusNumber = removeBlank(bonusNumber);
        bonusNumberValidator.validate(bonusNumber);
        return parseToLong(bonusNumber);
    }

    private String removeBlank(String userInput) {
        if (userInput.contains(InputConstant.BLANK_SYMBOL)) {
            userInput = userInput.replace(InputConstant.BLANK_SYMBOL, InputConstant.VOID_SYMBOL);
        }
        return userInput;
    }

    private String removeBlankInEachSeperatedItems(String winningLottoNumbers) {
        String[] numbers = splitItemsWithDelimiter(winningLottoNumbers);
        return Arrays.stream(numbers)
                .map(this::removeBlank)
                .collect(Collectors.joining(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER));
    }

    private Long parseToLong(String userInput) {
        return Long.parseLong(userInput);
    }

    private List<Long> parseToLongList(String userInput) {
        String[] numbers = splitItemsWithDelimiter(userInput);
        return Arrays.stream(numbers)
                .map(Long::parseLong)
                .toList();
    }

    private String[] splitItemsWithDelimiter(String userInput) {
        return userInput.split(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER);
    }
}