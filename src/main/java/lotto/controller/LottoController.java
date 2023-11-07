package lotto.controller;

import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LottoController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final LottoService lottoService = new LottoService();

    private static final String DELIMITER = ",";

    private static final String NOT_NUMERIC_EXCEPTION_MESSAGE = "숫자를 입력해주세요.";

    private static final String NUMERIC_REGX = "^[\\d]*$";

    public void run() {
        Player player = inputPurchaseAmount();
        printLottoAmountAndLottoNumbers(player);
        WinningLotto winningLotto = inputWinningNumbersAndBonusNumber();
        printResult(player, winningLotto);
    }

    private Player inputPurchaseAmount() {
        outputView.printInputPurchaseAmount();

        try {
            return getPlayer();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private Player getPlayer() {
        String stringPurchaseAmount = inputView.inputPurchaseAmount();
        validateNumeric(stringPurchaseAmount);
        int purchaseAmount = Integer.parseInt(stringPurchaseAmount);
        return lottoService.createPlayer(purchaseAmount);
    }

    private void printLottoAmountAndLottoNumbers(Player player) {
        outputView.printLottoAmountAndLottoNumbers(player.getLottos());
    }

    private WinningLotto inputWinningNumbersAndBonusNumber() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();

        try {
            return lottoService.createWinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputWinningNumbersAndBonusNumber();
        }

    }

    private int inputBonusNumber() {
        try {
            outputView.printInputBonusNumber();
            return getBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputBonusNumber();
        }
    }

    private int getBonusNumber() {
        String stringBonusNumber = inputView.inputBonusNumbers();
        validateNumeric(stringBonusNumber);
        return Integer.parseInt(stringBonusNumber);
    }

    private List<Integer> inputWinningNumbers() {
        try {
            outputView.printInputWinningNumbers();
            return getWinningNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private List<Integer> getWinningNumbers() {
        String stringWinningNumbers = inputView.inputWinningNumbers();
        String[] splitStringWinningNumbers = stringWinningNumbers.split(DELIMITER);

        for (String splitStringWinningNumber : splitStringWinningNumbers)
            validateNumeric(splitStringWinningNumber);

        return convertStringToIntegerList(splitStringWinningNumbers);
    }

    private Map<Rank, Integer> printWinningStatistics(Player player, WinningLotto winningLotto) {
        Map<Rank, Integer> winningStatistics = lottoService.makeWinningStatistics(player, winningLotto);
        outputView.printWinningStatistics(winningStatistics);
        return winningStatistics;
    }

    private void printReturnOfRatio(Player player, Map<Rank, Integer> winningStatistics) {
        double returnOfRatio = lottoService.calculateReturnOfRatio(player, winningStatistics);
        outputView.printRateOfReturn(returnOfRatio);
    }

    private void printResult(Player player, WinningLotto winningLotto) {
        Map<Rank, Integer> winningStatistics = printWinningStatistics(player, winningLotto);
        printReturnOfRatio(player, winningStatistics);
    }

    private List<Integer> convertStringToIntegerList(String[] stringWinningNumbers) {
        return Arrays.stream(stringWinningNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumeric(String input) {
        Matcher matcher = Pattern.compile(NUMERIC_REGX).matcher(input);
        if (!matcher.matches() || input.isEmpty())
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION_MESSAGE);
    }

}
