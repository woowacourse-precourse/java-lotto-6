package lotto.model;
import lotto.dto.LottoInfoDTO;

import java.util.List;
public class Lottos {
    private final List<LottoInfoDTO> lottoInfoDTOS;
    public Lottos(final List<LottoInfoDTO> lottoInfoDTOS){
        this.lottoInfoDTOS = lottoInfoDTOS;
    }
    public Integer getLottoLength() {
        return lottoInfoDTOS.size();
    }
    public List<LottoInfoDTO> getLottos(){
        return lottoInfoDTOS;
    }
    @Override
    public String toString() {
        final String OPEN_BRACKET = "[";
        final String CLOSE_BRACKET = "]";
        StringBuilder sb = new StringBuilder();
        for (LottoInfoDTO lottoINfoDTO : lottoInfoDTOS) {
            sb.append(OPEN_BRACKET).append(lottoINfoDTO.getLotto().toString()).append(CLOSE_BRACKET);
            sb.append("\n");
        }
        return sb.toString();
    }
}
