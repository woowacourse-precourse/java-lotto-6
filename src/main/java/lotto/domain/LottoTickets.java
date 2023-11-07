package lotto.domain;

import lotto.config.ConstNum;
import lotto.config.LottoRank;
import lotto.validation.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final LottoGenerator lottoGenerator;

    private ArrayList<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets() {
        this.lottoGenerator = new LottoGenerator();
    }

    public List<Lotto> buyLotto(Integer money) {
        int ticket = money / ConstNum.PRICE.getNum();

        while (lottoTickets.size() != ticket) {
            List<Integer> lottoNum = lottoGenerator.generate();
            Lotto lotto = new Lotto(lottoNum);
            lottoTickets.add(lotto);
        }

        LottoValidator.ticketSizeValidate(lottoTickets, ticket);

        return Collections.unmodifiableList(lottoTickets);
    }

    public Result getResult(WinningNum winningNum) {
        ArrayList<Integer> result = new ArrayList<>(List.of(0,0,0,0,0,0));

        for (Lotto lottoTicket : lottoTickets) {
            Integer rank = winningNum.compare(lottoTicket);

            if(rank== LottoRank.LOSE.getNum()) continue;

            result.set(rank, result.get(rank) + 1);
        }

        return new Result(result);
    }

    public List<String> getTickets() {
        ArrayList<String> tickets = new ArrayList<>();

        for (Lotto lottoTicket : lottoTickets) {
            String lotto = lottoTicket.getLotto();
            tickets.add(lotto);
        }

        return Collections.unmodifiableList(tickets);
    }
}
