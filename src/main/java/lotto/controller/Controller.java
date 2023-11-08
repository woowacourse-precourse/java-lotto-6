package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoCountDTO;
import lotto.dto.LottoResultDTO;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public Controller(final InputView inputView, final OutputView outputView, final LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        List<Lotto> lottos = buyLottos();
        LottoResult lottoResult = askWinningNumbers();
        printLottoWinningStatistics(lottoResult.calculateResult(lottos));
        close();
    }

    private List<Lotto> buyLottos() {
        LottoPurchaseAmount lottoPurchaseAmount = askLottoPurchaseAmount();
        Count lottoCount = lottoPurchaseAmount.getLottoCount();
        printLottoPurchaseCount(new LottoCountDTO(lottoCount.count()));
        List<Lotto> lottos = lottoIssuance(lottoCount);
        printLottoNumbers(lottos);
        return lottos;
    }

    private LottoPurchaseAmount askLottoPurchaseAmount() {
        try {
            printInputLottoPurchaseAmount();
            return LottoPurchaseAmount.create(
                    Parser.stringToInt(inputView.inputLottoPurchaseAmount())
            );
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return askLottoPurchaseAmount();
        }
    }

    private void printInputLottoPurchaseAmount() {
        outputView.printInputLottoPurchaseAmount();
    }

    private List<Lotto> lottoIssuance(Count lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottoCount.hasMoreCount()) {
            lottos.add(lottoGenerator.generate());
            lottoCount = lottoCount.next();
        }
        return lottos;
    }

    private void printLottoPurchaseCount(final LottoCountDTO lottoCountDTO) {
        outputView.printLottoPurchaseCount(lottoCountDTO);
    }

    private void printLottoNumbers(final List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::toDTO)
                .forEach(outputView::printLottoNumbers);
    }

    private LottoResult askWinningNumbers() {
        try {
            Lotto winningLotto = askWinningLotto();
            BonusNumber bonusNumber = askBonusNumber();
            return LottoResult.create(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return askWinningNumbers();
        }
    }

    private Lotto askWinningLotto() {
        try {
            printInputWinningLotto();
            return new Lotto(
                    Parser.stringToIntList(inputView.inputWinningLotto())
            );
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return askWinningLotto();
        }
    }

    private void printInputWinningLotto() {
        outputView.printInputWinningLotto();
    }

    private BonusNumber askBonusNumber() {
        try {
            printInputBonusNumber();
            return BonusNumber.create(
                    Parser.stringToInt(inputView.inputBonusNumber())
            );
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return askBonusNumber();
        }
    }

    private void printInputBonusNumber() {
        outputView.printInputBonusNumber();
    }

    private void printErrorMessage(final String errorMessage) {
        outputView.printErrorMessage(errorMessage);
    }

    private void printLottoWinningStatistics(final LottoResultDTO lottoResultDTO) {
        outputView.printLottoWinningStatistics(lottoResultDTO);
    }

    private void close() {
        inputView.close();
    }
}