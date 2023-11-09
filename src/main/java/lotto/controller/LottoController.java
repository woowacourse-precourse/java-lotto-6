package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.dto.GameResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.InputView.inputBonusNumber;


public class LottoController {
    private static final String COMMA_SEPARATOR = ",";
    public Lottos createLottos(final int count) {
        return new Lottos(count);
    }

    public static void printLottos(Lottos lottos) {
        OutputView.printLottos(lottos);
    }

    public WinningNumbers createLottoWinningNumbers() {
        final String numbers = inputWinningNumbers();
        final Lotto lotto = new Lotto(changeNumbersToLotto(numbers));
        final LottoNumber bonusNumber = new LottoNumber(inputBonusNumber());

        return new WinningNumbers(lotto, bonusNumber);
    }

    private String inputWinningNumbers() {
        return removeNumberSpace(InputView.inputWinningNumbers());
    }

    private List<LottoNumber> changeNumbersToLotto(String numbers) {
        return Arrays.stream(numbers.split(COMMA_SEPARATOR))
                .map((s) -> removeNumberSpace(s))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private String removeNumberSpace(final String number) {
        return number.replace(" ", "");
    }

    public GameResult generateResult(WinningNumbers winningNumbers, Lottos lottos) {
        GameResult gameResult = new GameResult();
        for (Lotto lotto : lottos.getTotalLottos()) {
            gameResult.calculateWinningResult(winningNumbers, lotto);
        }
        return gameResult;
    }

    public void printLottoWinningResult(GameResult gameResult) {
        OutputView.printLottoWinningResult(gameResult);
    }
}
