package lotto.service;

import static lotto.settings.LottoSettings.LOTTO_NUMBER_SIZE;

import java.util.ArrayList;
import java.util.List;

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

    public List<List<Integer>> getResult() {
        return result;
    }

    public void matchingNumber(int cnt){
    }

}
