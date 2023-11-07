package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.constants.DomainConstants;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(this.lottos);
    }

    public void addLotto(int amount) {
        int lottoCount = calculateLottoTicket(amount);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateRandomNumbers();
            lottos.add(generateLotto(lottoNumbers));
        }
    }

    private Lotto generateLotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private List<Integer> generateRandomNumbers() {
        int startNumber = DomainConstants.RANDOM_START_NUMBER.getConstants();
        int endNumber = DomainConstants.RANDOM_END_NUMBER.getConstants();
        int countNumber = DomainConstants.RANDOM_COUNT_NUMBER.getConstants();
        return Randoms.pickUniqueNumbersInRange(startNumber, endNumber, countNumber);
    }

    private int calculateLottoTicket(int amount) {
        return (amount / DomainConstants.LOTTO_PRICE.getConstants());
    }
}
