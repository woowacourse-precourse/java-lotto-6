package lotto.lotto;

import java.util.stream.IntStream;

import lotto.number.LottoNumberService;
import lotto.user.User;
import lotto.user.UserService;

public class LottoService {

    private final UserService userService;
    private final LottoNumberService lottoNumberService;
    private static final int LOTTO_PRICE = 1000;

    public LottoService(UserService userService, LottoNumberService lottoNumberService){
        this.userService = userService;
        this.lottoNumberService = lottoNumberService;
    }

    public void buyAllPurchasableLotto(User user){
        IntStream.range(0, getPurchasableLottoCount(user))
                .forEach(index -> buyLotto(user));
    }
    private int getPurchasableLottoCount(User user){
        return userService.getUserAssets(user) / LOTTO_PRICE;
    }

    private void buyLotto(User user){
        user.addLotto(Lotto.forUserLotto(lottoNumberService.pickAutoNumbers()));
    }
}
