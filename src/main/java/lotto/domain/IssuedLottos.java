package lotto.domain;

import java.util.List;
import lotto.domain.IssuedLotto;

public class IssuedLottos {
    List<IssuedLotto> Issued_Lottos;
    int amount;

    public IssuedLottos(List<IssuedLotto> Issued_Lottos,int amount){
        this.Issued_Lottos = Issued_Lottos;
        this.amount = amount;
    }

    public List<Integer> find_issued_lotto_by_index(int index){
        return Issued_Lottos.get(index).findAll();
    }

    public void add(IssuedLotto lotto) {
        Issued_Lottos.add(lotto);
    }

    public int size(){
        return Issued_Lottos.size();
    }

    public int getAmount(){
        return this.amount;
    }
}
