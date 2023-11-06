package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final List<Lotto> lottoList;

    public LottoManager(){
        this.lottoList=new ArrayList<>();
    }
    public void addLotto(Lotto lotto){
        this.lottoList.add(lotto);
    }
    public List<Lotto> getLottoList(){
        return this.lottoList;
    }
}
