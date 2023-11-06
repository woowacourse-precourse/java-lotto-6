package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine { //구매 횟수만큼 로또 번호 조합 발행, 도메인 로직과 관련된 당첨 번호, 보너스 번호 검증, 각 로또의 당첨 여부 판단

    public ArrayList<Lotto> runLottoMachine(Integer lottoCount) {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(createLotto());
        }
        return lottoTickets;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

}
