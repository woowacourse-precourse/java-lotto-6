package lotto.domain.user;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import lotto.domain.lotto.Lotto;

public class User {

    private int asset;
    private int prize;
    private List<Lotto> myLotto = new ArrayList<>();
    public static User fromAsset(int asset){
        return new User(asset);
    }
    private User(int asset){
        this.prize = 0;
        this.asset = asset;
    }

    public void addLotto(Lotto lotto){
        this.myLotto.add(lotto);
    }
    public void addPrize(int prize){
        this.prize += prize;
    }
    public BigDecimal getRateOfReturn() {
        return BigDecimal.valueOf(prize).divide(BigDecimal.valueOf(asset), 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
    }

    public int getAsset(){
        return this.asset;
    }
    public List<Lotto> getMyLotto(){
        return this.myLotto;
    }
}
