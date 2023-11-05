package lotto.domain;

import lotto.enums.LottoNumbers;
import lotto.utils.Logs;
import lotto.utils.Reader;

import java.util.Arrays;
import java.util.List;

public class Game {
    private Player player;
    private WinningLotto winningLotto;

    public void joinPlayer() {
        player = new Player(inputMoney());

        player.issueLotto();
        Logs.print(player.issuedLottos());
    }

    public void drawWinningLotto() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    public void findResult() {
        player.findResults(winningLotto);
        player.findTotalPrize();
        Logs.print(player.lottoResults());
    }

    private int inputMoney() {
        try {
            Logs.inputMoney();
            String input = Reader.readLine().strip();
            validateMoney(input);
            Logs.newLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            Logs.inputMoneyERROR();
            Logs.newLine();
            return inputMoney();
        }
    }

    private void validateMoney(String input) {
        int money = Integer.parseInt(input);

        if (money % 1_000 != 0 || money < 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> inputWinningNumbers() {
        try {
            Logs.inputWinningNumbers();
            String input = Reader.readLine();
            List<Integer> winningNumbers = validateWinningNumbers(input);
            Logs.newLine();
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            Logs.inputWinningNumbersERROR();
            Logs.newLine();
            return inputWinningNumbers();
        }
    }

    private List<Integer> validateWinningNumbers(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(",", -1))
                .map(this::validateWinningNumber)
                .toList();

        if (winningNumbers.size() != Lotto.getNumbersSize()
                || winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }

        return winningNumbers;
    }

    private int validateWinningNumber(String input) {
        int winningNumber = Integer.parseInt(input.strip());

        if (!LottoNumbers.contains(winningNumber)) {
            throw new IllegalArgumentException();
        }

        return winningNumber;
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        try {
            Logs.inputBonusNumber();
            String input = Reader.readLine().strip();
            validateBonusNumber(input, winningNumbers);
            Logs.newLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            Logs.inputBonusNumberERROR();
            Logs.newLine();
            return inputBonusNumber(winningNumbers);
        }
    }

    private void validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(input);
        if (!LottoNumbers.contains(bonusNumber)
                || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
