package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    private static List<Lotto> lotto = new ArrayList<>();

    public List<Lotto> buyAllLotto(int money){
        for(int i=0;i<money;i++){
            Lotto paper = new Lotto(pickNumber());
            lotto.add(paper);
        }
        return lotto;
    }
    public List<Integer> pickNumber(){
        List<Integer> paper = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(paper);
        return paper;
    }
    public boolean checkSameNumber(List<Integer> paper, int number) {
        boolean result = true;
        for (int i = 0; i < paper.size(); i++) {
            if (paper.get(i) == number) {
                result = false;
                break;
            }
        }
        return result;
    }
}
