package lotto.model;

import java.util.LinkedList;
import java.util.List;

public class LottoArrays {

    private final List<Lotto> lottoList;

    public LottoArrays(){
        this.lottoList = new LinkedList<>();
    }

    public void addLottoArray(Lotto lottoArray){
        this.lottoList.add(lottoArray);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
