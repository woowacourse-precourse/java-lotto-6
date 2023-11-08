package lotto.domain.model;

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

    public List<PrizeOption> matchUp(Lotto answerLotto, int bonusNumber) {
        return lottos.stream()
                .map(i -> getResult(i, answerLotto, bonusNumber))
                .toList();
    }
    private PrizeOption getResult(Lotto userLotto, Lotto answerLotto, Integer bonusNumber) {
        int numberOfMatch = userLotto.matchUp(answerLotto);
        return PrizeOption.matchUp(numberOfMatch, userLotto, bonusNumber);
    }
    public List<Lotto> getLottosForMessage() {
        return lottos;
    }

}
