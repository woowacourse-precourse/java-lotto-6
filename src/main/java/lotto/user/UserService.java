package lotto.user;


import lotto.lotto.Lotto;
import lotto.lotto.LottoService;
import lotto.number.LottoNumberService;

import java.util.stream.IntStream;

public class UserService {

    private final LottoService lottoService;

    public UserService(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public User createUser(int assets){
        return new User(assets);
    }

    public void buyAllPurchasableLotto(User user){
        IntStream.range(0, getPurchasableLottoCount(user))
                .forEach(index -> lottoService.buyLotto(user));
    }

    public int getUserAssets(User user){
        return user.getAsset();
    }

    private int getPurchasableLottoCount(User user){
        return getUserAssets(user) / lottoService.LOTTO_PRICE;
    }
}
