package lotto.model;

import static lotto.constant.Magic.END_INRANGE;
import static lotto.constant.Magic.NUMBERS_INLOTTO;
import static lotto.constant.Magic.STRAT_INRANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottosList {

    private List<Lotto> lottosList = new ArrayList<>();

    public LottosList() {

    }

    public LottosList(String price) {

    }


    public List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(STRAT_INRANGE, END_INRANGE, NUMBERS_INLOTTO);
    }


}
