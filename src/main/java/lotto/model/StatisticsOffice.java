package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsOffice {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private StatisticsOffice(Lotto winningLotto, LottoNumber bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto winningLotto, LottoNumber bonusNumber){
        if(winningLotto.hasNumber(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public static StatisticsOffice registerWinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        return new StatisticsOffice(new Lotto(winningLotto), new LottoNumber(bonusNumber));
    }


}
