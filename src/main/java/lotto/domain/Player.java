package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    Map<Lotto,Integer> lottos;

    public Player() {
        lottos = new HashMap<Lotto,Integer>();
    }

    public void addLotto(Lotto lotto) {
        lottos.put(lotto, 0);
    }

    public List<Integer> getCorrectLottoCounts(){

        return null;
    }

    public int getNumberOfLotto(){
        return lottos.size();
    }
}
