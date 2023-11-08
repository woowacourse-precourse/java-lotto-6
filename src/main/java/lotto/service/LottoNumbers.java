package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public LottoNumbers() {
    }

    private static List<Integer> lottoNumberList;

    public static List<Integer> getRandomNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoTicketNumberList = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoTicketNumberList);
        return lottoTicketNumberList;
    }
}
