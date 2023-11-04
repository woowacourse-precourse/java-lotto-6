package lotto.controller.lotto;

import java.util.Arrays;
import java.util.List;
import lotto.controller.Controller;
import lotto.domain.Lotto;
import lotto.service.WinningLottoService;
import lotto.view.BasicView;
import lotto.view.View;

public class WinningLottoSaveController implements Controller {
    private final WinningLottoService winningLottoService;

    public WinningLottoSaveController(WinningLottoService winningLottoService) {
        this.winningLottoService = winningLottoService;
    }

    @Override
    public View process(List<String> input) {
        List<Integer> numbers = Arrays.stream(input.get(0).split(","))
                                    .map(String::trim)
                                    .map(Integer::parseInt).toList();

        int bonus = Integer.parseInt(input.get(1));
        //TODO: 예외처리 해야힘

        winningLottoService.saveWinningLotto(new Lotto(numbers), bonus);

        return new BasicView();
    }
}
