package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private List<Integer> result = new ArrayList<>(Collections.nCopies(7, 0));


    public void checkLottoNumbers(List<Integer> userLotto, List<Integer> winnerLotto){
        int rightCount = 0;
        for(int i=0;i<6;i++){
            if(winnerLotto.contains(userLotto.get(i))){
                rightCount++;
            }
        }
        result.set(rightCount,result.get(rightCount)+1);
    }

    public List<Integer> getResult(){
        return this.result;
    }
}
