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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoInfo lottoINfo : lottoInfos) {
            sb.append(lottoINfo.getLotto().toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
