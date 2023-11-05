package lotto.service;

import static lotto.settings.LottoSettings.LOTTO_NUMBER_SIZE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LotteryTracker {
    List<List<Integer>> result = new ArrayList<>();

    public void create(){
        int size = LOTTO_NUMBER_SIZE.getNumber(); // 복권숫자 크기:6
        for(int i = 0; i<= size; i++){
            result.add(new ArrayList<>());
        }
    }

    public int countLottoIn(int index){
        return result.get(index).size();
    }

    public void matchingNumber(int cnt, Lotto buyLotto, int bonusNumber){
        if(cnt==3){
            result.get(5).add(cnt);}
        else if(cnt==4){
            result.get(4).add(cnt);}
        else if(cnt==5){
            if(buyLotto.has(bonusNumber)){
                result.get(2).add(cnt);
            }
            result.get(3).add(cnt);
        }
        else if(cnt==6){
            result.get(1).add(cnt);}
    }



}
