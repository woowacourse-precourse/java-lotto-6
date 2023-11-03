package lotto.domain;

import lotto.Lotto;
import lotto.io.InputHandler;


public class UserLotto {

    private final LottoRepository userLottory = new LottoRepository();

    public UserLotto() {
        buyLotto();
    }

    private void buyLotto(){
        int count = InputHandler.readMoney()/1000;
        for(int i=0;i<count;i++){
            userLottory.add(makeLotto());
        }
    }
    private Lotto makeLotto(){
        return new Lotto(RandomNumGenerator.makeUniqueRandomList());
    }
}
