package lotto;

import java.util.List;

public class IssuedLottos {
    List<IssuedLotto> Issued_Lottos;

    public IssuedLottos(List<IssuedLotto> Issued_Lottos){
        this.Issued_Lottos = Issued_Lottos;
    }

    public List<Integer> find_issued_lotto_by_index(int index){
        return Issued_Lottos.get(index).findAll();
    }
}
