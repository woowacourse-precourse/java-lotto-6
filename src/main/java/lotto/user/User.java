package lotto.user;

import java.util.List;
import lotto.bank.Bank;
import lotto.number.LottoNumber;
import lotto.pay.Lotto;
import lotto.pay.LottoService;

public class User {

    private int asset;
    private List<Lotto> myLotto;

    public User(int asset){
        this.asset = asset;
    }

    public void addLotto(Lotto lotto){
        this.myLotto.add(lotto);
    }

    public int getAsset(){
        return this.asset;
    }
}
