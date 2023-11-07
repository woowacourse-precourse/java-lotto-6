package lotto.domain;

import lotto.utils.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottoTickets;

    public LottoGame(int purchaseAmount){
        this.lottoTickets = generateLottoTickets(purchaseAmount);
    }

    public List<Lotto> generateLottoTickets(int purchaseAmount){

        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i<purchaseAmount; i++){

            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
    }

    public List<Integer> getLottoTicket(int index){
        Lotto lotto = lottoTickets.get(index);
        return lotto.getLottoNumbers();
    }

    public List<Lotto> getLottoTickets(){

        return this.lottoTickets;
    }


}
