package lotto.Function;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateLotto {

    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer PICKUP_NUMBER = 6;

    //티켓 수 만큼 로또 번호 생성
    public List<Lotto> generateLottoTickets(int ticket) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            lottoTickets.add(generateLottoNumber());
        }
        return lottoTickets;
    }

    public Lotto generateLottoNumber() {
        return new Lotto(generateLotto_RandomNumbers());
    }

    private List<Integer> generateLotto_RandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, PICKUP_NUMBER);
    }


}
