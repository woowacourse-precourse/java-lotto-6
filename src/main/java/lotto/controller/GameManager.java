package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.Price;
import lotto.view.InputView;

public class GameManager{

    public void run(){
        Price price = InputView.inputPurchasePrice();
        Lottos lottos = issueRandomLottosByPrice(price);
    }

    private Lottos issueRandomLottosByPrice(Price price){
        int lottoCount = price.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<lottoCount;i++){
            lottos.add(Lotto.issueRandomLotto());
        }
        return new Lottos(lottos);
    }

}
