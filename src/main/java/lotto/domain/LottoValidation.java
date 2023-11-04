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

    public boolean checkDuplicateLottoNumber(List<Integer> lottoNumber) {
        if (lottoNumber.size() != lottoNumber.stream().distinct().count()) {
            return false;
        }
        return true;
    }

    public boolean checkBonusNumberRange(int bonusNumber, int min, int max) {
        if (bonusNumber < min || bonusNumber > max) {
            return false;
        }
        return true;
    }

    public boolean checkDuplicateBonusNumber(List<Integer> lottoNumber, int bonusNubmber) {
        for (int nowNumber : lottoNumber) {
            if (nowNumber == bonusNubmber) {
                return false;
            }
        }
        return true;
    }
}
