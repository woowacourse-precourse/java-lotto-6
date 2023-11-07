package lotto.domain.user;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.lotto.Lotto;

public class User {

    private int asset;
    private List<Lotto> myLotto = new ArrayList<>();
    public static User fromAsset(int asset){
        return new User(asset);
    }
    public User(int asset){
        this.asset = asset;
    }

    public void addLotto(Lotto lotto){
        this.myLotto.add(lotto);
    }

    public int getAsset(){
        return this.asset;
    }
    public List<Lotto> getMyLotto(){
        return this.myLotto;
    }
}
