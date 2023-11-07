package lotto.domain;

import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Lotto> lottoTicket;

    public LottoTicket() {
        this.lottoTicket = new ArrayList<>();
    }

    public void createLotto(int ticketCount) {
        LottoNumberGenerator lottoNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lotto = lottoNumberGenerator.generateLottoNumbers();
            lottoTicket.add(new Lotto(lotto));
        }
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoTicket) {
            sb.append(lotto.toString()).append("\n");
        }
        return sb.toString();
    }
}
