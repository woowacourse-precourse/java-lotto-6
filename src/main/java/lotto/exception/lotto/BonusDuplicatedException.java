package lotto.exception.lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class BonusDuplicatedException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 로또 숫자는 보너스번호와 중첩될수 없습니다. 로또 : %s 보너스 : %s";

    public BonusDuplicatedException(Lotto winLotto, LottoNumber bonus){
        super(String.format(ERROR_MESSAGE,winLotto,bonus));
    }
}