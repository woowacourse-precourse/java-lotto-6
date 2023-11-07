package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import lotto.util.RandomChoice;;

public class User {
    List<Lotto> lotto = new ArrayList<Lotto>();
    private int purchaseAmount;
    
    public User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
    
    public void setLotto(){
        for (int i = 0; i < getPurchaseAmount(); i++) {
            lotto.add(new Lotto(RandomChoice.createLottoNumbers()));
        }
    }
    
    public int getPurchaseAmount(){
        return purchaseAmount;
    }

    public List<Lotto> getLottoList(){
        return lotto;
    }

}
