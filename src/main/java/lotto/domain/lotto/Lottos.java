package lotto.domain.lotto;

import java.util.List;
import lotto.domain.WinningResult;
import lotto.domain.lotteryresult.LotteryResult;
import lotto.domain.lotto.Lotto;

public class Lottos{

    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public WinningResult determineWinnings(LotteryResult lotteryResult){
        return null;
    }

    public int getSize(){
        return lottos.size();
    }

}
