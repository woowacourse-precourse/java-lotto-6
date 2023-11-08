package lotto.controller.result;

import java.util.List;
import lotto.controller.Controller;
import lotto.domain.Money;
import lotto.domain.WinningResult;
import lotto.service.UserService;
import lotto.service.WinningLottoService;
import lotto.view.View;
import lotto.view.WinningResultView;

public class WinningResultController implements Controller {
    private final WinningLottoService winningLottoService;
    private final UserService userService;

    public WinningResultController(WinningLottoService winningLottoService, UserService userService) {
        this.winningLottoService = winningLottoService;
        this.userService = userService;
    }

    @Override
    public View process(List<String> input) {
        List<WinningResult> winningResults = winningLottoService.calculateAllWinningResult(userService.findUser());

        Money totalProfit = winningResults.stream()
                .map(WinningResult::totalProfit)
                .reduce(Money::plus)
                .orElse(Money.ZERO);

        double rateOfReturn = userService.calculateRateOfReturn(totalProfit);

        return new WinningResultView(winningResults, rateOfReturn);
    }
}
