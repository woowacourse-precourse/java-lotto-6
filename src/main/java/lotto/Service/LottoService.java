package lotto.Service;

import lotto.domain.Lottos;
import lotto.dto.LottoRequestDTO;
import lotto.dto.LottoResponseDTO;

public class LottoService {
    private static LottoService instance = new LottoService();

    private LottoService() {}

    public static LottoService getInstance() {
        return instance;
    }

    public Lottos lottoSell(String money){
        return new Lottos(money);
    }
    public LottoResponseDTO countScore(LottoRequestDTO lottoRequestDTO){
        return null;
    }

}
