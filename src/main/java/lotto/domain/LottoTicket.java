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
            try {
                lottoTicket.add(new Lotto(lotto));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
