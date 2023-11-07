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
        outputProcessor.outputPurchaseMoneyInputMessage();
        int purchaseMoney = requestRepeatedly(inputProcessor::getUserPurchaseMoney);
        int numberOfLottos = purchaseMoney / PURCHASE_MONEY_UNIT;
        outputProcessor.outputNewLine();
        outputProcessor.outputNumberOfLottos(numberOfLottos);
        List<Lotto> lottos = issueLottos(numberOfLottos);
        for (Lotto lotto : lottos) {
            outputProcessor.outputLotto(lotto);
        }
        outputProcessor.outputNewLine();
        outputProcessor.outputWinningNumberInputMessage();
        List<Integer> winningNumbers = requestRepeatedly(inputProcessor::getWinningNumbers);
        outputProcessor.outputNewLine();
        outputProcessor.outputBonusNumberInputMessage();
        int bonusNumber = requestRepeatedly(inputProcessor::getBonusNumber);
        outputProcessor.outputNewLine();
        Game game = new Game(winningNumbers, bonusNumber, lottos);
        WinningInformation winningInformation = WinningInformation.of(game.calculateRanks());
        outputProcessor.outputWinningInformation(winningInformation);
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
