package lotto.model;

import lotto.Lotto;
import lotto.WinningLotto;
import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final RandomNumberGenerator numberGenerator;

    public LottoTickets(RandomNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void createTicket(int ticketPiecesCount) {
        while (ticketPiecesCount-- > 0) {
            lottoTickets.add(new Lotto(numberGenerator.getRandomNumbers()));
        }
    }

    public HashMap<Result, Integer> calculateWinningLotto(WinningLotto winningLotto) {
        HashMap<Result, Integer> resultMap = new HashMap<>();

        for (Lotto lottoTicket : lottoTickets) {
            HitsNumber hitsNumber = lottoTicket.calculate(winningLotto);
            Result result = Result.getResult(hitsNumber);

            resultMap.put(result, resultMap.getOrDefault(result, 0) + 1);
        }
        return resultMap;
    }


    public int getLottoTicketsSize() {
        return lottoTickets.size();
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
