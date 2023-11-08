package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userLotto; //사용자의 로또 번호가 담길 리스트
    boolean hasBonus = false;

    public void setUserLotto(List<Integer> LottoNumbers) {
        this.userLotto = LottoNumbers;
    }

    public List<Integer> getUserLotto() {
        return userLotto;
    }

    public void setHasBonus(int number) {
        if (userLotto.contains(number)) {
            hasBonus = true;
        }
    }

    public boolean getHasBonus() {
        return hasBonus;
    }

}
