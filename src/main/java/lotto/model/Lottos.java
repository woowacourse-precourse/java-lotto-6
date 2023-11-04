package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateLottos(int ticketAmount) {
        List<Lotto>  arr = new ArrayList<>();
        for(int i = 0 ;i<ticketAmount ; i++){
            arr.add(Lotto.generateLottoByRandom());
        }
        return new Lottos(List.copyOf(arr));
    }

    public List<LottoResult> matchLottos(Lotto answer, int bonusNumber) {
        List<LottoResult> arr = new ArrayList<>();
        for(Lotto userLotto : lottos) {
            arr.add(userLotto.matchUp(answer,bonusNumber));
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder();
        for(Lotto lotto : lottos){
            sb.append(lotto);
        }
        return sb.toString();
    }
}
