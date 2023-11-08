package lotto.controller.user;

import java.util.List;
import lotto.controller.Controller;
import lotto.service.UserService;
import lotto.view.LottoBuyCountView;
import lotto.view.View;

public class UserBuyLottoController implements Controller {
    private final UserService userService;

    public UserBuyLottoController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public View process(List<String> input) {
        int buyCount = userService.buyLotto();
        return new LottoBuyCountView(buyCount);
    }
}
