package lotto.model;

import lotto.util.MakeRandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private List<Lotto> lottoBundle;
    private final Integer lottoTicketNumber;

    public LottoBundle(Integer lottoNumber){
        this.lottoBundle = new ArrayList<>();
        this.lottoTicketNumber = lottoNumber;
    }

    public void makeLottoBundle(){
        for(int num = 0; num < lottoTicketNumber; num ++){
            Lotto lotto = new Lotto(MakeRandomNumbers.getRandomNumbers());
            lottoBundle.add(lotto);
        }
    }
}
