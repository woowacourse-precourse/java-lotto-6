package lotto.Factory;

import java.util.ArrayList;
import java.util.List;

public class LottoContainer {
    private List<Lotto> lottoContainer = new ArrayList<>();
    private List<Lotto> WinningLotto = new ArrayList<>();
    public void MakeContainer(int count){
        for(int i=0; i<count; i++){
            lottoContainer.add(Lotto.createLotto());
        }
    }

    public void MakeWinningLotto(List<Integer> WinningInput){
        WinningLotto.add(Lotto.createLotto(WinningInput));
    }

}
