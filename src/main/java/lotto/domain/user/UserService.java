package lotto.domain.user;

import lotto.domain.lotto.LottoService;

import java.util.stream.IntStream;

public class UserService {

    private final LottoService lottoService;

    public UserService(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public User createUser(int assets){
        return User.fromAsset(assets);
    }

    public UserLottoResponse buyAllPurchasableLotto(User user){
        IntStream.range(0, getPurchasableLottoCount(user))
                .forEach(index -> user.addLotto(lottoService.buyLotto()));
        return new UserLottoResponse(user);
    }

    public int getUserAssets(final User user){
        return user.getAsset();
    }

    public RateOfReturnResponse getUserRateOfReturn(final User user){
        return RateOfReturnResponse.from(user.getRateOfReturn());
    }

    private int getPurchasableLottoCount(final User user){
        return getUserAssets(user) / lottoService.LOTTO_PRICE;
    }
}
