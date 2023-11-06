package lotto.model;

import lotto.util.MakeRandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;


    public LottoBundle(){
        this.lottoBundle = new ArrayList<>();
    }

    public void makeLottoBundle(int lottoTicketNumber){
        for(int num = 0; num < lottoTicketNumber; num ++){
            Lotto lotto = new Lotto(MakeRandomNumbers.getRandomNumbers());
            lottoBundle.add(lotto);
        }
    }

    public List<Integer> getLottoBundle(int num){
        return lottoBundle.get(num).getLottoNumber();
    }
}
