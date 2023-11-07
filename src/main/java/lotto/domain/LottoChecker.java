package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoChecker {

    private List<Lotto> lottos;
    private List<Integer> winningNumbers = new ArrayList<>(6);
    private int bonusNumber;



    public LottoChecker(List<Lotto> lottos, String winningNumbers, String bonusNumber) {
        this.lottos = lottos;
        for(String num : winningNumbers.split(",")){
            this.winningNumbers.add(Integer.parseInt(num));
        }
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> checkResult(){
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        result.add(0);
        result.add(0);
        result.add(0);

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
