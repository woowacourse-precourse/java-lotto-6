package lotto.domain.lotto;

import java.util.List;
import lotto.domain.WinningResult;

public class Lottos{

    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public WinningResult determineWinnings(Lotto lotto, Bonus bonus){
        return null;
    }

    public int getSize(){
        return lottos.size();
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

}
