package lotto;

import lotto.domain.LottoBoard;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningInformation;
import lotto.input.ConsoleInputReader;
import lotto.input.InputProcessor;
import lotto.output.ConsoleOutputSender;
import lotto.output.OutputProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class GameManager {
    private InputProcessor inputProcessor;
    private OutputProcessor outputProcessor;

    public GameManager() {
        this.inputProcessor = new InputProcessor(new ConsoleInputReader());
        this.outputProcessor = new OutputProcessor(new ConsoleOutputSender());
    }

    public void run() {
        outputProcessor.outputPurchaseMoneyInputMessage();
        List<Lotto> lottos = requestRepeatedly(this::purchase);
        showLottos(lottos);

        outputProcessor.outputWinningNumberInputMessage();
        Lotto winningLotto = requestRepeatedly(this::chooseWinningNumbers);

        outputProcessor.outputBonusNumberInputMessage();
        LottoBoard lottoBoard = requestRepeatedly(lottos, winningLotto, this::makeLottoBoard);

        processResult(lottoBoard);
    }

    private void processResult(LottoBoard lottoBoard) {
        WinningInformation winningInformation = WinningInformation.of(lottoBoard.calculateRanks());
        outputProcessor.outputWinningInformation(winningInformation);
    }

    private LottoBoard makeLottoBoard(List<Lotto> lottos, Lotto winningLotto) {
        int bonusNumber = inputProcessor.getBonusNumber();
        LottoBoard lottoBoard = new LottoBoard(winningLotto, bonusNumber, lottos);
        outputProcessor.outputNewLine();
        return lottoBoard;
    }

    private Lotto chooseWinningNumbers() {
        List<Integer> winningNumbers = inputProcessor.getWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        outputProcessor.outputNewLine();
        return winningLotto;
    }

    private List<Lotto> purchase() {
        Integer amount = inputProcessor.getUserPurchaseMoney();
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        int numberOfLottos = purchaseAmount.toNumberOfLottos();
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

    private <T, U, R> R requestRepeatedly(T t, U u, BiFunction<T, U, R> biFunction) {
        while (true) {
            try {
                return biFunction.apply(t, u);
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
