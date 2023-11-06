package lotto;

import java.util.List;

public class User {
    final private int lottoCnt;
    final private List<Lotto> lotto;

    public User(int lottoCnt, List<Lotto> lotto){
        this.lottoCnt = lottoCnt;
        this.lotto = lotto;
    }

    public List<Lotto> getLotto(){
        return lotto;
    }

    public int getLottoCnt(){
        return lottoCnt;
    }
}
