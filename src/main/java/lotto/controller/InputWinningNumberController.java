package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.service.BonusNumberValidateService;
import lotto.service.LottoValidateService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputWinningNumberController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoValidateService lottoService = new LottoValidateService();
    private final BonusNumberValidateService bonusNumberService = new BonusNumberValidateService();
    private Lotto winLotto;

    public Lotto saveWinLottoNumber() {
        List<String> numbers = inputWinLottoNumber();
        while (!lottoService.validate(numbers)) {
            numbers = inputWinLottoNumber();
        }
        while (!tryCreateLotto(numbers)) {
            numbers = inputWinLottoNumber();
        }
        return winLotto;
    }

    private List<String> inputWinLottoNumber() {
        outputView.inputWinLottoNumberNoticeOutput();
        return stringToList(inputView.input());
    }

    private List<String> stringToList(String input) {
        return Arrays.stream(input.replace(" ", "").split(",")).toList();
    }

    private boolean tryCreateLotto(List<String> numbers) {
        try {
            winLotto = new Lotto(stringListToIntegerList(numbers));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private List<Integer> stringListToIntegerList(List<String> stringList) {
        return stringList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    public int saveBonusNumber() {
        String bonus = inputBonusNumber();
        while (!bonusNumberService.validate(bonus, winLotto.getNumbers())) {
            bonus = inputBonusNumber();
        }
        return Integer.parseInt(bonus);
    }

    private String inputBonusNumber() {
        outputView.inputBonusNumberNoticeOutput();
        return inputView.input();
    }
}
