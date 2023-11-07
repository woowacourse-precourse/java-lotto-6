package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Buyer {

    private static int money;
    private List<List<Integer>> lottoCollection = new ArrayList<>();

    public Buyer(int money) {
        this.money = money;
    }

    public int getMoney(){
        return money;
    }

    public void setLottoCollection(List<Integer> lotto){
        //Collections.sort(lotto);
        lottoCollection.add(lotto);
    }

    public List<Integer> getLottoCollection(int num){
        return lottoCollection.get(num);
    }

    public List<List<Integer>> getAllLottoCollection(){
        return lottoCollection;
    }

}
