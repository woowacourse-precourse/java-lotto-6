package lotto;

import java.util.List;
import lotto.Service.OutputService;


public class Player {
    private final List<Lotto> lottos;

    public Player(int n) {
        this.lottos = LottoGenerator.getLottosByCount(n);
    }

    public int getLottoSize() {
        return this.lottos.size();
    }

    public void printLottos(){
        System.out.print(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto:
             lottos) {
            OutputService.printLottoNumbers(lotto);
        }
    }

    public int matchCountWithWinnings(int idx, Lotto winningLotto){
        if(idx < 0 || idx >= this.lottos.size())
            throw new IllegalStateException("에러 발생");
        return winningLotto.getHowManySameNumbers(this.lottos.get(idx));
    }

    public boolean matchesBonus(int idx, Lotto winningLotto, int bonusNumber){
        if(idx < 0 || idx >= this.lottos.size())
            throw new IllegalStateException("에러 발생");
        return winningLotto.hasBonus(this.lottos.get(idx), bonusNumber);
    }
}
