package lotto.util;

import lotto.domain.Lotto;

import static lotto.constant.LottoConsts.MAX_NUMBER;
import static lotto.constant.LottoConsts.MIN_NUMBER;

public class LottoUtil {

    public static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환하는 도중 오류가 발생하였습니다.");
        }
    }

    public static int parseLottoNumber(String input) {
        int lottoNumber = parseInteger(input);

        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d부터 %d사이의 값이어야 합니다.", MIN_NUMBER, MAX_NUMBER));
        }

        return lottoNumber;
    }

    public static int parseLottoBonusNumber(String input, Lotto winningLotto) {
        int bonusNumber = parseLottoNumber(input);

        if (winningLotto.containNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }

        return bonusNumber;
    }

}
