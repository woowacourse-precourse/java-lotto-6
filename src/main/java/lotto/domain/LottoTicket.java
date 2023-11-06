package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.constants.DomainConstants;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket() {
        this.lottoTicket = new ArrayList<>();
    }

    public void createLottoTicket(int lottoCount) {
        addLotto(lottoCount);
    }

    private void addLotto(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = generateRandomNumbers();
            lottoTicket.add(generateLotto(lottoNumbers));
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

    public List<Lotto> getLottoTicket() {
        return new ArrayList<>(this.lottoTicket);
    }
}
