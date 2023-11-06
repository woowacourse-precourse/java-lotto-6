package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.validate.InputValidation;

/* 로또 번호 랜덤 생성기
* */
public class LottoGenerator {
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(0,0,0,0,0,0)));
    Purchase purchase;
    LottoStorage lottoStorage;
    public LottoGenerator() {

    }

    public List<Integer> generateNumber() {
        lotto.setNumber(new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45,1)));
        return lotto.getNumbers();
    }

}
