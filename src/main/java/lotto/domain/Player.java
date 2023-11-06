package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    Map<Lotto,CorrectCount> lottos;

    public Player() {
        lottos = new HashMap<Lotto,CorrectCount>();
    }

    public void addLotto(Lotto lotto) {
        lottos.put(lotto, new CorrectCount(0,0));
    }

    public List<Lotto> getLottoPapers(){
        return lottos.keySet().stream().toList();
    }

    public List<CorrectCount> getCorrectLottoCounts(){
        return lottos.values().stream().toList();
    }

    public int getNumberOfLotto(){
        return lottos.size();
    }

    public void setLottoCorrectCount(Lotto lotto, CorrectCount correctCount){
        CorrectCount replace = lottos.replace(lotto, correctCount);

        if(replace == null){
            //TODO: 존재하지 않는 로또에 대해서는 예외처리가 필요함.
        }
    }
}
