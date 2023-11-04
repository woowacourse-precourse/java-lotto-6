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

    public boolean checkDuplicateLottoNumber(List<Integer> lottoNumber, int nowNumber) {
        int count = 0;
        for (int number : lottoNumber) {
            if (nowNumber == number) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
