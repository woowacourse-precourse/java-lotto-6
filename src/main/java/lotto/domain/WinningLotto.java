package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoRangeException;
import lotto.exception.SameNumberInBonusException;
import lotto.exception.SameNumberInLottoException;

public class WinningLotto {
    private final Integer MIN_NUM = 1;
    private final Integer MAX_NUM = 45;

    private final Lotto win;
    private Integer bonus;

    public WinningLotto(List<Integer> win) {
        validateSameNumbers(win);
        for(Integer number : win) {
            validateRange(number);
        }
        this.win = new Lotto(win);
        this.bonus = 0;
    }

    public void setBonusNumber(Integer bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    public void validate(Integer bonus) {
        validateBonusInWin(bonus);
        validateRange(bonus);
    }

    public void validateSameNumbers(List<Integer> win) {
        if(win.size() != win.stream().distinct().count()){
            throw new SameNumberInLottoException();
        }
    }

    public void validateBonusInWin(Integer bonus) {
        if(win.getNumbers().contains(bonus)){
            throw new SameNumberInBonusException();
        }
    }

    public void validateRange(Integer number) {
        if(!(number>=MIN_NUM && number<=MAX_NUM)) {
            throw new LottoRangeException();
        }
    }

    public Lotto getWin() {
        return win;
    }

    public Integer getBonusNumber() {
        return bonus;
    }
}
