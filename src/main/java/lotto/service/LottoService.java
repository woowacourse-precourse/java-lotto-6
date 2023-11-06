package lotto.service;

import java.util.HashMap;
import java.util.Map;

public class LottoService {

    public Map<String, String> setUserLottoNumbersAndBonusNumber(String inputUserLottoNumbers, String inputUserBonusNumber) {

        Map<String, String> userLottoNumbersAndBonusNumber = new HashMap<>();

        userLottoNumbersAndBonusNumber.put("userLottoNumbers", inputUserLottoNumbers);
        userLottoNumbersAndBonusNumber.put("userBonusNumber", inputUserBonusNumber);

        return userLottoNumbersAndBonusNumber;
    }
}
