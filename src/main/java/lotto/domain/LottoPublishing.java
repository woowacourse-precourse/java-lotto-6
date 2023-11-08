package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoPublishing {
    List<Integer> lottoNumber;
    List<Lotto> lottos = new ArrayList<Lotto>();
    private void createRandomNumber() {
        List <Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumber = new ArrayList<Integer>(numbers);
        Collections.sort(lottoNumber);
    }

    public List<Lotto> publishLotto(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            createRandomNumber();
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);
        }
        return lottos;
    }
}
