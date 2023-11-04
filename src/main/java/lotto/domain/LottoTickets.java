package lotto.domain;

import lotto.validation.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final LottoGenerator lottoGenerator;

    private ArrayList<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets() {
        this.lottoGenerator = new LottoGenerator();
    }

    public ArrayList<Lotto> buyLotto(Integer money) {
        int ticket = money / ConstNum.PRICE.getNum();

        while (lottoTickets.size() != ticket) {
            List<Integer> lottoNum = lottoGenerator.generate();
            Lotto lotto = new Lotto(lottoNum);
            lottoTickets.add(lotto);
        }

        LottoValidator.ticketSizeValidate(lottoTickets, ticket);

        return lottoTickets;
    }

    public Result getResult(WinningNum winningNum) {
        ArrayList<Integer> result = new ArrayList<>(List.of(0,0,0,0,0,0));

        for (Lotto lottoTicket : lottoTickets) {
            Integer rank = winningNum.compare(lottoTicket);

            if(rank==ConstNum.LOSE.getNum()) continue;

            result.set(rank, result.get(rank) + 1);
        }

        return new Result(result);
    }

    @Override
    public String toString() {
        String result = "";
        for (Lotto lottoTicket : lottoTickets) {
            result += lottoTicket.toString()+'\n';
        }

        return result;
    }
}
