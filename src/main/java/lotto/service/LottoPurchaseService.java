package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.ExceptionConstants.INPUT_ZERO_MESSAGE;
import static lotto.constants.ExceptionConstants.INVALID_NON_THOUSAND_UNIT_MESSAGE;
import static lotto.constants.ServiceConstants.*;

public class LottoPurchaseService {
    public Long calculateNumberOfLotto(Long inputMoney) {
        validateInputMoney(inputMoney);
        return inputMoney / DIVIDE_STANDARD;
    }

    private void validateInputMoney(Long inputMoney) {
        if (!isValidUnitAmount(inputMoney)) {
            throw new InvalidInputException(INVALID_NON_THOUSAND_UNIT_MESSAGE);
        }
        if (isZeroAmount(inputMoney)) {
            throw new InvalidInputException(INPUT_ZERO_MESSAGE);
        }
    }

    private Boolean isZeroAmount(Long inputMoney) {
        return inputMoney.equals(ZERO_AMOUNT);
    }

    private Boolean isValidUnitAmount(Long inputMoney) {
        return inputMoney % DIVIDE_STANDARD == ZERO_AMOUNT;
    }

    public List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_STANDARD);
        return sortNumbersInAscendingOrder(new ArrayList<>(lottoNumbers));
    }

    private List<Integer> sortNumbersInAscendingOrder(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
