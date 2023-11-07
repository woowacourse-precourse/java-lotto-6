package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {

    public static List<Integer> setRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<Lotto> makeLottoTicket(Integer PaperNumber) { //로또 번호 만들기
        List<Lotto> lottos = new ArrayList<>();;
        for (int i = 0; i < PaperNumber; i++) {
            List<Integer> lottoNumbers = setRandomNumbers();
            System.out.println(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }
}
