package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.validateIsEmpty(lottos);
        this.lottos = lottos;
    }

    private void validateIsEmpty(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTOS_IS_NOT_EMPTY.message());
        }
    }

    public static Lottos generateByAmount(Amount amount) {
        List<Lotto> lottos = new ArrayList<>();
        int purchaseNumber = amount.getPurchaseNumber();
        for (int count = 0; count < purchaseNumber; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    public void getResult(Lotto winningLotto) {
        // TODO: 로또 추첨 결과를 반환하는 기능 구현
    }
}
