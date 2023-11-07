package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private static List<Integer> lottoRandomNumber;
    private static final List<Lotto> lottoList = new ArrayList<>();



    public List<Lotto> randomNumber(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottoRandomNumber = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_COUNT);
            lottoList.add(new Lotto(lottoRandomNumber));
        }
        return lottoList;
    }
}
