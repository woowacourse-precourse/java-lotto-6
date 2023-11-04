package lotto.domain;

import java.util.List;

public class UserLotto {

    private Lotto mainLottoNumber;
    private int bonusNumber; //유효검사

    public UserLotto(Lotto mainLottoNumber, int bonusNumber) {
        this.mainLottoNumber = mainLottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getMainLottoNumber(){
        return mainLottoNumber.getNumbers();
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
