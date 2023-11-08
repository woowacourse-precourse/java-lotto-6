package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoChecker {

    private List<Lotto> lottos;
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;
    private List<Integer> result;



    public LottoChecker(List<Lotto> lottos, String winningNumbers, String bonusNumber) {
        this.lottos = lottos;
        for(String num : winningNumbers.split(",")){
            this.winningNumbers.add(Integer.parseInt(num));
        }
        this.bonusNumber = Integer.parseInt(bonusNumber);
        result = Arrays.asList(0,0,0,0,0);
    }

    public List<Integer> checkResult(){
        for(Lotto lotto : lottos){
            int n = checkNumber(lotto)-3;
            if(n>=0) result.set(n,result.get(n)+1);
        }

        return result;
    }

    public int checkNumber(Lotto lotto){
        int count = 0;

        for(int num : lotto.getNumbers()){
            if(winningNumbers.contains(num)) count++;
        }

        if(count==6) count=7;
        if(count==5 && lotto.getNumbers().contains(bonusNumber)) count=6;

        return count;
    }
}
