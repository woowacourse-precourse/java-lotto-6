package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoConstant.*;

public class InputValidator {

    public void validateUserLottoPriceInput(String inputUserPrice) {
        try {
            Integer.parseInt(inputUserPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 되어야 합니다. 다시 입력해주세요.");
        }
    }

    public void validateLottoSheets(String inputUserPrice) {
        int price = Integer.parseInt(inputUserPrice);

        if (price % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매해야 합니다. 다시 입력해주세요.");
        }
    }

    public void validateLottoNumbericInput(String inputLottoNumbers) {
        try {
            separateNumber(inputLottoNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 되어야 합니다. 다시 입력해주세요.");
        }
    }

    public void validateLottoNumberSize(String inputLottoNumbers) {
        List<Integer> lottoNumbers = separateNumber(inputLottoNumbers);
            
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해야 합니다. 다시 입력해주세요.");
        }
        
    }
    
    public void validateLottoNumberOfRange(String inputLottoNumbers) {
        List<Integer> lottoNumbers = separateNumber(inputLottoNumbers);
        
        for (int number : lottoNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateDuplicateLottoNumber(String inputLottoNumber) {
        List<Integer> lottoNumber = separateNumber(inputLottoNumber);
        HashSet<Integer> uniqueNumber = new HashSet<>(lottoNumber);

        if (uniqueNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public void validateDuplicateNumber(List<Integer> lottoNumbers, String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public void validateBonusNumberic(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
    
    public void validateBonusNumberOfRange(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private List<Integer> separateNumber(String inputLottoNumbers) {
        return Arrays.stream(inputLottoNumbers.split(LOTTO_NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }
}
