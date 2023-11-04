package lotto.domain;

import java.util.List;

public class LottoValidation {
    public boolean checkLottoNumberRange(List<Integer> lottoNumber, int min, int max) {
        for (int i = 0; i < lottoNumber.size(); i++) {
            if (lottoNumber.get(i) < min || lottoNumber.get(i) > max) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicateLottoNumber(List<Integer> lottoNumber, int bonusNumber) {
        if (lottoNumber.size() != lottoNumber.stream().distinct().count()) {
            return false;
        }

        for (int i = 0 ; i< lottoNumber.size(); i++) {
            if (bonusNumber == lottoNumber.get(i)) {
                return false;
            }
        }

        return true;
    }
}
