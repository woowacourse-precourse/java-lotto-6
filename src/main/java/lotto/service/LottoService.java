package lotto.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private static final int VALID_LOTTO_SIZE = 6;
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;

    private static final String COMMON_ERROR_MESSAGE = "[ERROR] ";
    private static final String INVALID_LOTTO_SIZE_MESSAGE = COMMON_ERROR_MESSAGE + "당첨 번호는 6자리의 숫자여야 합니다.";
    private static final String DUPLICATE_LOTTO_MESSAGE = COMMON_ERROR_MESSAGE + "당첨 번호는 서로 중복 될 수 없습니다.";
    private static final String ONLY_NUMBER_MESSAGE = COMMON_ERROR_MESSAGE + "당첨 번호는 숫자로만 이루어져야 합니다.";
    private static final String INVALID_LOTTO_RANGE_MESSAGE = COMMON_ERROR_MESSAGE + "당첨 번호는 1~45 사이의 숫자여야 합니다.";

    public Map<String, String> setUserLottoNumbersAndBonusNumber(String inputUserLottoNumbers, String inputUserBonusNumber) {
        Map<String, String> userLottoNumbersAndBonusNumber = new HashMap<>();
        userLottoNumbersAndBonusNumber.put("userLottoNumbers", inputUserLottoNumbers);
        userLottoNumbersAndBonusNumber.put("userBonusNumber", inputUserBonusNumber);

        return userLottoNumbersAndBonusNumber;
    }

    public void userLottoNumbersValidate(String userLottoNumbers) {
        String[] splitUserLottoNumbers = userLottoNumbers.split(",");
        List<String> tempUserLottoNumbers = Arrays.asList(splitUserLottoNumbers);
        // 로또가 6자리인지 확인한다.
        if (tempUserLottoNumbers.size() != VALID_LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }

        for (String tempUserLottoNumber : tempUserLottoNumbers) {
            // 각 로또 번호가 숫자인지 체크한다.
            if (!isInteger(tempUserLottoNumber)) {
                throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
            }

            // 로또 번호가 1~45 사이의 값인지 체크한다.
            int pickUserLottoNumber = Integer.parseInt(tempUserLottoNumber);
            if (pickUserLottoNumber < LOTTO_MINIMUM_NUMBER || pickUserLottoNumber > LOTTO_MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(INVALID_LOTTO_RANGE_MESSAGE);
            }
        }

        // 로또 번호에 중복된 숫자가 있는지 체크
        if(tempUserLottoNumbers.size() != tempUserLottoNumbers.stream().distinct().count()){
            throw new IllegalArgumentException(DUPLICATE_LOTTO_MESSAGE);
        }
    }

    public boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
