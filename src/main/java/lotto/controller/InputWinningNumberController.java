package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.InputService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputWinningNumberController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputService inputService = new InputService();
    private Lotto winLotto;

    public Lotto saveWinLottoNumber() {
        List<String> numbers = inputWinLottoNumber();
        while (!inputService.lottoValidate(numbers)) {
            numbers = inputWinLottoNumber();
        }
        while (!tryCreateLotto(numbers)) {
            numbers = inputWinLottoNumber();
        }
        return winLotto;
    }

    private List<String> inputWinLottoNumber() {
        outputView.inputWinLottoNumberNoticeOutput();
        return inputService.stringToList(inputView.input());
    }

    private boolean tryCreateLotto(List<String> numbers) {
        try {
            winLotto = new Lotto(inputService.stringListToIntegerList(numbers));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public int saveBonusNumber() {
        String bonus = inputBonusNumber();
        while (!inputService.bonusNumberValidate(bonus, winLotto.getNumbers())) {
            bonus = inputBonusNumber();
        }
        return Integer.parseInt(bonus);
    }

    private String inputBonusNumber() {
        outputView.inputBonusNumberNoticeOutput();
        return inputView.input();
    }
}
