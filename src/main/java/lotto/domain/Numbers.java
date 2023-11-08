package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    public static int MIN_NUM = 1;
    public static int MAX_NUM = 45;
    public static int SIZE_NUM = 6;

    public static List<Integer> setRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, SIZE_NUM);
        List<Integer> copyLotto = new ArrayList<>(lottoNumbers);
        Collections.sort(copyLotto);
        return copyLotto;
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
