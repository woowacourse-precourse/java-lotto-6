package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userLotto; //사용자의 로또 번호가 담길 리스트

    public void setUserLotto(List<Integer> LottoNumbers) {
        this.userLotto = LottoNumbers;
    }

    public List<Integer> getUserLotto() {
        return userLotto;
    }

}
