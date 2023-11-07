package lotto.model;

import java.util.List;
public class Lottos {
    private final List<LottoInfo> lottoInfos;

    public Lottos(final List<LottoInfo> lottoInfos){
        this.lottoInfos = lottoInfos;
    }

    public Integer getLottoLength() {
        return lottoInfos.size();
    }

    public List<LottoInfo> getLottoInfoList(){
        return lottoInfos;
    }

    @Override
    public String toString() {
        final String OPEN_BRACKET = "[";
        final String CLOSE_BRACKET = "]";
        StringBuilder sb = new StringBuilder();
        for (LottoInfo lottoINfo : lottoInfos) {
            sb.append(OPEN_BRACKET).append(lottoINfo.getLotto().toString()).append(CLOSE_BRACKET);
            sb.append("\n");
        }
        return sb.toString();
    }
}
