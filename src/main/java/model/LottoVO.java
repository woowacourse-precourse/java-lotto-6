package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.GameProperty;

public class LottoVO {
    private List<List<Integer>> purchaseLotto;

    private LottoVO() {
    }

    public LottoVO(int money) {
        purchaseLotto(money);
    }

    public void purchaseLotto(int money) {
        int ea = money / 1000;
        for (int i = 0; i < ea; i++) {
            Set<Integer> lottoNumber = new HashSet<>();
            while (lottoNumber.size() == 6) {
                lottoNumber.add(Randoms.pickNumberInRange
                        (GameProperty.LOTTO_MIN_NUMBER, GameProperty.LOTTO_MAX_NUMBER));
            }
            purchaseLotto.add(new ArrayList<>(lottoNumber));
        }
    }

    public List<List<Integer>> getPurchaseLotto() {
        return purchaseLotto;
    }
}
