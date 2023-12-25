package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RandomLottoTickets {

    private final List<LottoTicket> lottoTickets;

    public RandomLottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public void generateLottoTicket() {
        lottoTickets.add(new LottoTicket(LottoNumbersGenerator.generateNumbers()));
    }

    public List<Optional<Rank>> sort(WinningLottoTicket winningLottoTicket) {
        return lottoTickets.stream().map(lotto -> Rank.sort(lotto, winningLottoTicket)).toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTickets) {
            sb.append(lottoTicket).append("\n");
        }
        return sb.toString();
    }
}
