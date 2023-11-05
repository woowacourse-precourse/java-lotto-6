package lotto.util;

import lotto.domain.Lotto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MakeLotto {

    public MakeLotto(int tickets){
        OutputView.ticketCountMessage(tickets);
        makeLottoList(tickets);
    }

    public List<Lotto> makeLottoList(int tickets){
        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i<tickets; i++){
            Lotto lotto = new Lotto(MakeRandomNumbers.getRandomNumbers());
            System.out.println(lotto.getLottoNumbers());
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
