package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import static model.Lotto.*;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> Lottos = new ArrayList<Lotto>();

    List<Integer> makeLottoNumbers() {
        List<Integer> LottoNumbers = new ArrayList<>();
        int currentLottoSize = 0;
        while (currentLottoSize < LOTTO_NUMBER_SIZE) {
            int LottoNumber = Randoms.pickNumberInRange(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER);
            if (!LottoNumbers.contains(LottoNumber)) {
                LottoNumbers.add(LottoNumber);
            }
            currentLottoSize++;
        }
        return LottoNumbers;
    }

    void purchaseLotto(int money) {
        while (money > 0) {
            Lottos.add(new Lotto(makeLottoNumbers()));
            money -= LOTTO_PRICE;
        }
    }
}
