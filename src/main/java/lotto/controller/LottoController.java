package lotto.controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.MainNumbers;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.util.generator.LottoNumberGenerator;
import lotto.util.generator.NumberGenerator;
import lotto.util.mapper.DtoModelMapper;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = getValidPurchaseAmount();
        Lottos lottos = issueLottos(new LottoNumberGenerator(), purchaseAmount.calculateLottoCount());
        WinningNumbers winningNumbers = getWinningNumbers();

        LottoResult lottoResult = LottoResult.getResultFrom(lottos, winningNumbers, purchaseAmount);
        outputView.printLottoResult(DtoModelMapper.LottoResultToDto(lottoResult));
    }

    private PurchaseAmount getValidPurchaseAmount() {
        while (true) {
            try {
                return DtoModelMapper.dtoToPurchaseAmount(inputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos issueLottos(NumberGenerator numberGenerator, int lottoCount) {
        Lottos lottos = Stream.generate(() -> Lotto.issue(numberGenerator.generate()))
                .limit(lottoCount)
                .collect(collectingAndThen(toList(), Lottos::assemble));
        outputView.printLottosIssued(DtoModelMapper.LottosToDto(lottos));

        return lottos;
    }

    private MainNumbers getValidMainNumbers() {
        while (true) {
            try {
                return DtoModelMapper.dtoToMainNumbers(inputView.readMainNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber getValidBonusNumbers() {
        while (true) {
            try {
                return DtoModelMapper.dtoToBonusNumbers(inputView.readBonusNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        MainNumbers mainNumbers = getValidMainNumbers();

        while (true) {
            BonusNumber bonusNumber = getValidBonusNumbers();
            try {
                return WinningNumbers.of(mainNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}