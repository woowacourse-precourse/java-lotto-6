package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningDetail {
    private final List<CountOfCorrectLotto> countOfCorrectLottos;

    public WinningDetail(){
        this.countOfCorrectLottos = new ArrayList<>();
    }

    public void add(CountOfCorrectLotto countOfCorrectLotto){
        this.countOfCorrectLottos.add(countOfCorrectLotto);
    }

    public void sort(){
        countOfCorrectLottos.sort((e1, e2) -> e2.getWinningRank() - e1.getWinningRank());
    }

    public List<CountOfCorrectLotto> getCountOfCorrectLottos(){
        return countOfCorrectLottos;
    }
}
