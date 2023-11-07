package lotto.lotto;

import java.util.stream.IntStream;

import lotto.number.LottoNumberService;
import lotto.user.User;
import lotto.user.UserService;

public class LottoService {
    private final LottoNumberService lottoNumberService;
    public static final int LOTTO_PRICE = 1000;

    public LottoService(LottoNumberService lottoNumberService){
        this.lottoNumberService = lottoNumberService;
    }

    public Lotto buyLotto(User user){
        return Lotto.forUserLotto(lottoNumberService.pickAutoNumbers());
    }
}
