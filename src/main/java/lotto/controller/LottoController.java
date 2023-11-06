package lotto.controller;

import static lotto.constant.ExceptionMessage.BONUS_NUMBER_QUANTITY_ERROR;
import static lotto.constant.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ExceptionMessage.LOTTO_SIZE_ERROR;
import static lotto.constant.ExceptionMessage.NON_NUMERIC_ERROR;
import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoInfo.BONUS_NUMBER_SIZE;
import static lotto.constant.LottoInfo.LOTTO_SIZE;
import static lotto.constant.LottoInfo.MAXIMUM_NUMBER;
import static lotto.constant.LottoInfo.MINIMUM_NUMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.MatchedLottoCount;
import lotto.dto.InputNumbersDTO;
import lotto.service.PlayerService;

public class LottoController {

    private static final String SPLIT_REGEX = ",";

    private final PlayerService playerService;

    private static LottoController INSTANCE;

    private LottoController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public static LottoController getInstance(PlayerService playerService) {
        if (INSTANCE == null) {
            INSTANCE = new LottoController(playerService);
        }
        return INSTANCE;
    }

    public MatchedLottoCount inputNumbers(InputNumbersDTO inputNumbersDTO) {
        List<Integer> inputNumbers =
                validateDuplicateNumber(validateIsNumeric(validateInputSize(inputNumbersDTO.getInputNumbers())));

        validateBonusNumber(inputNumbersDTO.getBonusNumber());

        return playerService.compareLottoNumbers(inputNumbers, Integer.parseInt(inputNumbersDTO.getBonusNumber()));
    }

    private void validateBonusNumber(String input) {
        validateInputIsNull(input);
        String[] splitInput = input.split(SPLIT_REGEX);
        validateBonusNumberSize(splitInput);
        validateNumberRange(validateIsNumeric(splitInput));
    }

    private static void validateInputIsNull(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(BONUS_NUMBER_QUANTITY_ERROR.getMessage());
        }
    }

    private static void validateBonusNumberSize(String[] splitInput) {
        if (splitInput.length != BONUS_NUMBER_SIZE.getInfo()) {
            throw new IllegalArgumentException(BONUS_NUMBER_QUANTITY_ERROR.getMessage());
        }
    }

    private String[] validateInputSize(String input) {
        String[] splitInput = input.split(SPLIT_REGEX);
        if (Arrays.stream(splitInput).count() != LOTTO_SIZE.getInfo()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }

        return splitInput;
    }

    private List<Integer> validateIsNumeric(String[] splitInput) {
        List<Integer> inputNumbers = new ArrayList<>();

        for (String inputNumber : splitInput) {
            if (!isNumeric(inputNumber)) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR.getMessage());
            }

            inputNumbers.add(Integer.parseInt(inputNumber));
        }

        return inputNumbers;
    }

    private boolean isNumeric(String inputNumber) {
        for (char inputCh : inputNumber.toCharArray()) {
            if (!Character.isDigit(inputCh)) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = numbers.stream().collect(Collectors.toSet());
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }

        validateNumberRange(numbers);

        return numbers;
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
            if (number < MINIMUM_NUMBER.getInfo() || number > MAXIMUM_NUMBER.getInfo()) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
            }
        });
    }

}
