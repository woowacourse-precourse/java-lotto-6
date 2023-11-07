package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    public List<Lotto> lottos;
    public Lottos() {

    }
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> buyLottoByTicketAmount(Integer ticketAmount) {
        List<Lotto> arr = new ArrayList<>();
        IntStream.range(0, ticketAmount)
                .forEach(i -> arr.add(Lotto.newInstance(Randoms.pickUniqueNumbersInRange(1, 45, 6))));
        this.lottos = List.copyOf(arr);
        return this.lottos;
    }

    public LottosResult matchUp(Lotto answerLotto, int bonusNumber) {
        List<LottoResult> arr = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int something =lotto.matchUp(answerLotto);
            LottoResult re =LottoResult.matchUp(something,lotto,bonusNumber);
            arr.add(re);
        }
        return new LottosResult(arr);
    }

    public List<Lotto> getLottosForMessage() {
        return lottos;
    }
}
