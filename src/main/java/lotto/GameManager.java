package lotto;

import lotto.domain.LottoBoard;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningInformation;
import lotto.input.ConsoleInputReader;
import lotto.input.InputProcessor;
import lotto.output.ConsoleOutputFormatter;
import lotto.output.ConsoleOutputSender;
import lotto.output.OutputSender;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class GameManager {
    private InputProcessor inputProcessor;
    private OutputSender outputSender;

    public GameManager() {
        this.inputProcessor = new InputProcessor(new ConsoleInputReader());
        this.outputSender = new ConsoleOutputSender(new ConsoleOutputFormatter());
    }

    public void run() {
        outputSender.outputPurchaseMoneyInputMessage();
        List<Lotto> lottos = requestRepeatedly(this::purchase);
        showLottos(lottos);

        outputSender.outputWinningNumberInputMessage();
        Lotto winningLotto = requestRepeatedly(this::chooseWinningNumbers);

        outputSender.outputBonusNumberInputMessage();
        LottoBoard lottoBoard = requestRepeatedly(lottos, winningLotto, this::makeLottoBoard);

        processResult(lottoBoard);
    }

    private void processResult(LottoBoard lottoBoard) {
        WinningInformation winningInformation = WinningInformation.of(lottoBoard.calculateRanks());
        outputSender.outputWinningInformation(winningInformation);
    }

    private LottoBoard makeLottoBoard(List<Lotto> lottos, Lotto winningLotto) {
        int bonusNumber = inputProcessor.getBonusNumber();
        LottoBoard lottoBoard = new LottoBoard(winningLotto, bonusNumber, lottos);
        outputSender.outputNewLine();
        return lottoBoard;
    }

    private Lotto chooseWinningNumbers() {
        List<Integer> winningNumbers = inputProcessor.getWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        outputSender.outputNewLine();
        return winningLotto;
    }

    private List<Lotto> purchase() {
        Integer amount = inputProcessor.getUserPurchaseMoney();
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        int numberOfLottos = purchaseAmount.toNumberOfLottos();
        List<Lotto> lottos = issueLottos(numberOfLottos);
        outputSender.outputNewLine();
        return lottos;
    }

    private void showLottos(List<Lotto> lottos) {
        outputSender.outputNumberOfLottos(lottos.size());
        for (Lotto lotto : lottos) {
            outputSender.outputLotto(lotto);
        }
        outputSender.outputNewLine();
    }

    private <T> T requestRepeatedly(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputSender.outputError(e.getMessage());
            }
        }
    }

    private <T, U, R> R requestRepeatedly(T t, U u, BiFunction<T, U, R> biFunction) {
        while (true) {
            try {
                return biFunction.apply(t, u);
            } catch (IllegalArgumentException e) {
                outputSender.outputError(e.getMessage());
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
