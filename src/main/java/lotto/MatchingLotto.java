package lotto;

import java.util.ArrayList;
import java.util.List;

public class MatchingLotto {
    ArrayList<Lotto> lottos;
    WinningLotto winningLotto;
    ArrayList<Integer> matchingStatus = new ArrayList<Integer>(List.of(0, 0, 0, 0, 0));

    public MatchingLotto(ArrayList<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        checkMatching();
    }

    public void checkMatching() {
        int update;
        for (int i = 0; i < lottos.size(); i++){
            if (checkLotto(lottos.get(i), winningLotto) == 3){
                update = matchingStatus.get(0);
                update++;
                matchingStatus.set(0, update);
            }
            if (checkLotto(lottos.get(i), winningLotto) == 4){
                update = matchingStatus.get(1);
                update++;
                matchingStatus.set(1, update);
            }
            if (checkLotto(lottos.get(i), winningLotto) == 5){
                update = matchingStatus.get(2);
                update++;
                matchingStatus.set(2, update);
            }
            if (checkLotto(lottos.get(i), winningLotto) == 7){
                update = matchingStatus.get(3);
                update++;
                matchingStatus.set(3, update);
            }
            if (checkLotto(lottos.get(i), winningLotto) == 6){
                update = matchingStatus.get(4);
                update++;
                matchingStatus.set(4, update);
            }
        }
    }

    private int checkLotto(Lotto lotto, WinningLotto winningLotto){
        List<Integer> numbers = new ArrayList<Integer>(lotto.getNumbers());
        int count = 0;
        for(int i = 0; i < numbers.size(); i++){
            count += checkNumber(numbers.get(i), winningLotto.getNumbers());
        }
        if (count == 5 && numbers.contains(winningLotto.getBonus()))
            return 7;
        return count;
    }

    private int checkNumber(int number, List<Integer> numbers){
        if (numbers.contains(number)){
            return 1;
        }
        return 0;
    }

    public ArrayList<Integer> getMatchingStatus(){
        return this.matchingStatus;
    }
}
