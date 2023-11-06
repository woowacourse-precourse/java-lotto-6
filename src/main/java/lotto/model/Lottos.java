package lotto.model;
import java.util.List;
public class Lottos {
    private List<LottoInfo> lottoInfos;
    public Lottos(final List<LottoInfo> lottoInfos){
        this.lottoInfos = lottoInfos;
    }
    public Integer getLottoLength() {
        return lottoInfos.size();
    }
    public List<LottoInfo> getLottos(){
        return lottoInfos;
    }
}
