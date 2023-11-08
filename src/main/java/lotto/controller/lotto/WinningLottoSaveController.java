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

        validate(numbers, bonus);

        winningLottoService.saveWinningLotto(new Lotto(numbers), bonus);

        return new BasicView();
    }

    private void validate(List<Integer> numbers, int bonus) {
        if(numbers.contains(bonus)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 서로 달라야 합니다.");
        }
    }
}
