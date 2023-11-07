package lotto;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.WinningInformation;
import lotto.input.ConsoleInputReader;
import lotto.input.InputProcessor;
import lotto.output.ConsoleOutputSender;
import lotto.output.OutputProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static lotto.GameConfig.*;

public class GameManager {
    private InputProcessor inputProcessor;
    private OutputProcessor outputProcessor;

    public GameManager() {
        this.inputProcessor = new InputProcessor(new ConsoleInputReader());
        this.outputProcessor = new OutputProcessor(new ConsoleOutputSender());
    }

    public void run() {
        List<Lotto> lottos = purchase();
        showLottos(lottos);

        List<Integer> winningNumbers = chooseWinningNumbers();
        int bonusNumber = chooseBonusNumber();

        Game game = new Game(winningNumbers, bonusNumber, lottos);
        processResult(game);
    }

    private void processResult(Game game) {
        WinningInformation winningInformation = WinningInformation.of(game.calculateRanks());
        outputProcessor.outputWinningInformation(winningInformation);
    }

    private int chooseBonusNumber() {
        outputProcessor.outputBonusNumberInputMessage();
        // BonusNumber의 중복 여부를 여기서 직접 확인하지 않아서 try문에 안잡힘
        int bonusNumber = requestRepeatedly(inputProcessor::getBonusNumber);
        outputProcessor.outputNewLine();
        return bonusNumber;
    }

    private List<Integer> chooseWinningNumbers() {
        outputProcessor.outputWinningNumberInputMessage();
        List<Integer> winningNumbers = requestRepeatedly(inputProcessor::getWinningNumbers);
        outputProcessor.outputNewLine();
        return winningNumbers;
    }

    private List<Lotto> purchase() {
        outputProcessor.outputPurchaseMoneyInputMessage();
        int purchaseMoney = requestRepeatedly(inputProcessor::getUserPurchaseMoney);
        int numberOfLottos = purchaseMoney / PURCHASE_MONEY_UNIT;
        List<Lotto> lottos = issueLottos(numberOfLottos);
        outputProcessor.outputNewLine();
        return lottos;
    }

    private void showLottos(List<Lotto> lottos) {
        outputProcessor.outputNumberOfLottos(lottos.size());
        for (Lotto lotto : lottos) {
            outputProcessor.outputLotto(lotto);
        }
        outputProcessor.outputNewLine();
    }

    private <T> T requestRepeatedly(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputProcessor.outputError(e.getMessage());
            }
        }
    }

    private static List<Lotto> issueLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < numberOfLottos; count++) {
            lottos.add(Lotto.generateRandomLotto());
        }

        return lottos;
    }
}
