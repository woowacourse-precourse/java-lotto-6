package lotto.controller.user;

import java.util.List;
import lotto.controller.Controller;
import lotto.domain.Lotto;
import lotto.service.UserService;
import lotto.view.LottoOfUserView;
import lotto.view.View;

public class UserGetLottoController implements Controller {

    private final UserService userService;

    public UserGetLottoController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public View process(String input) {
        List<Lotto> lottos = userService.findLottosOfUser();
        return new LottoOfUserView(lottos);
    }
}
