package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    private int lottoAmount;

    public Buyer(int money) {
        lottos = new ArrayList<>();
        this.lottoAmount = money / LOTTO_PRICE;
    }

    public void buyLotto(){
        LotteryGenerator generator = new LotteryGenerator();
        for(int i=0; i<lottoAmount; i++){
            this.lottos.add(generator.getLotto());
        }
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

}
