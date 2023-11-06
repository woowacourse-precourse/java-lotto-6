package lotto.pay;

import java.util.stream.IntStream;
import lotto.user.User;
import lotto.user.UserService;

public class LottoService {

    private final UserService userService;
    private static final int LOTTO_PRICE = 1000;


    public LottoService(UserService userService){
        this.userService = userService;
    }
    public void buyAllPurchasableLotto(User user){
        IntStream.range(0, getPurchasableLottoCount(user))
                .forEach(index -> buyLotto(user));
    }
    private int getPurchasableLottoCount(User user){
        return userService.getUserAssets(user) / LOTTO_PRICE;
    }

    private void buyLotto(User user){
        user.addLotto(Lotto.auto());
    }
}
