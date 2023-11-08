package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    List<Lotto> lottoList = new ArrayList<>();
    private int totalPrice;

    public LottoList(Lotto lotto){
        lottoList.add(lotto);
    }
    public List<Lotto> getLottoList(){
        return lottoList;
    }
    public void setTotalPrice(int reward){
        this.totalPrice+=reward;
    }
    public int getTotalPrice(){
        return totalPrice;
    }

}
