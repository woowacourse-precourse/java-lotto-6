package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoConstant.*;

public class InputValidator {

    private static final String LOTTO_TEXT = "로또 번호";
    private static final String BONUS_NUMBER_TEXT = "보너스 번호";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s %s";
    private static final String REQUEST_RETRY_INPUT_MESSAGE = "다시 입력해주세요.";
    private static final String ERROR_INPUT_NUMBER_MESSAGE = "숫자만 입력되어야 합니다.";
    private static final String ERROR_INPUT_CORRECT_LOTTO_SIZE_MESSAGE = "숫자 %d개 입력되어야 합니다.";
    private static final String ERROR_INPUT_CORRECT_LOTTO_PRICE_MESSAGE = "로또는 %,d 단위로 구매해야 합니다.";
    private static final String ERROR_LOTTO_NUMBER_RANGE_MESSAGE = "%s는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBER_EXIST = "중복된 숫자가 존재합니다.";

    public void validateUserLottoPriceInput(String inputUserPrice) {
        try {
            Integer.parseInt(inputUserPrice);
        } catch (NumberFormatException e) {
            String errorMessage = String.format(ERROR_MESSAGE_FORMAT, ERROR_INPUT_CORRECT_LOTTO_SIZE_MESSAGE, REQUEST_RETRY_INPUT_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validateLottoSheets(String inputUserPrice) {
        int price = Integer.parseInt(inputUserPrice);

        if (price % PRICE_PER_LOTTO != 0) {
            String lottoPriceMessage = String.format(ERROR_INPUT_CORRECT_LOTTO_PRICE_MESSAGE, PRICE_PER_LOTTO);
            String errorMessage = String.format(ERROR_MESSAGE_FORMAT, lottoPriceMessage, REQUEST_RETRY_INPUT_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validateLottoNumbericInput(String inputLottoNumbers) {
        try {
            separateNumber(inputLottoNumbers);
        } catch (NumberFormatException e) {
            String errorMessage = String.format(ERROR_MESSAGE_FORMAT, ERROR_INPUT_NUMBER_MESSAGE, REQUEST_RETRY_INPUT_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validateLottoNumberSize(String inputLottoNumbers) {
        List<Integer> lottoNumbers = separateNumber(inputLottoNumbers);
            
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            String lottoSizeMessage = String.format(ERROR_INPUT_CORRECT_LOTTO_SIZE_MESSAGE, LOTTO_NUMBER_SIZE);
            String errorMessage = String.format(ERROR_MESSAGE_FORMAT, lottoSizeMessage, REQUEST_RETRY_INPUT_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
        
    }
    
    public void validateLottoNumberOfRange(String inputLottoNumbers) {
        List<Integer> lottoNumbers = separateNumber(inputLottoNumbers);
        
        for (int number : lottoNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                String lottoRangeMessage = String.format(ERROR_LOTTO_NUMBER_RANGE_MESSAGE, LOTTO_TEXT,MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
                String errorMessage = String.format(ERROR_MESSAGE_FORMAT, lottoRangeMessage, REQUEST_RETRY_INPUT_MESSAGE);
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    public void validateDuplicateLottoNumber(String inputLottoNumber) {
        List<Integer> lottoNumber = separateNumber(inputLottoNumber);
        HashSet<Integer> uniqueNumber = new HashSet<>(lottoNumber);

        if (uniqueNumber.size() != LOTTO_NUMBER_SIZE) {
            String errorMessage = String.format(ERROR_MESSAGE_FORMAT, ERROR_DUPLICATE_NUMBER_EXIST, REQUEST_RETRY_INPUT_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validateDuplicateNumber(List<Integer> lottoNumbers, String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        
        if (lottoNumbers.contains(bonusNumber)) {
            String errorMessage = String.format(ERROR_MESSAGE_FORMAT, ERROR_DUPLICATE_NUMBER_EXIST, REQUEST_RETRY_INPUT_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validateBonusNumberic(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            String errorMessage = String.format(ERROR_MESSAGE_FORMAT, ERROR_INPUT_NUMBER_MESSAGE, REQUEST_RETRY_INPUT_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
    }
    
    public void validateBonusNumberOfRange(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            String bonusRangeMessage = String.format(ERROR_LOTTO_NUMBER_RANGE_MESSAGE, BONUS_NUMBER_TEXT, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            String errorMessage = String.format(ERROR_MESSAGE_FORMAT, bonusRangeMessage, REQUEST_RETRY_INPUT_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private List<Integer> separateNumber(String inputLottoNumbers) {
        return Arrays.stream(inputLottoNumbers.split(LOTTO_NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }
}
