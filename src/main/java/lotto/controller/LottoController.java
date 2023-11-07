package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.dto.LottoMatchCountDto;
import lotto.dto.LottoViewDto;
import lotto.model.LottoModel;
import lotto.validate.BonusNumberValidation;
import lotto.validate.PurchaseAmountValidation;
import lotto.validate.WinningNumberValidation;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoModel lottoModel;

    public LottoController(final LottoInputView lottoInputView, final LottoOutputView lottoOutputView, final LottoModel lottoModel) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoModel = lottoModel;
    }

    public void startGame() {
        LottoViewDto lottoViewDto = new LottoViewDto();
        while (true) {
            try {
                playGame(lottoViewDto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void playGame(final LottoViewDto lottoViewDto) {
        if (!lottoViewDto.isPurchaseAmount()) inputPurchaseAmount(lottoViewDto);
        if (!lottoViewDto.isLottos()) printPurchaseLottos(lottoViewDto);
        if (!lottoViewDto.isWinningNumbers()) inputWinningNumber(lottoViewDto);
        if (!lottoViewDto.isBonusNumber()) inputBonusNumber(lottoViewDto);
        printLottoResult(lottoViewDto);
        printLottoRevenue(lottoViewDto);
    }

    private void inputPurchaseAmount(final LottoViewDto lottoViewDto) {
        lottoOutputView.printUserInputPurchaseAmount();
        int purchaseAmount = lottoInputView.inputPurchaseAmount(new PurchaseAmountValidation());

        lottoViewDto.setPurchaseAmountAndCount(purchaseAmount);
    }

    private void printPurchaseLottos(final LottoViewDto lottoViewDto) {
        int purchaseAmount = lottoViewDto.getPurchaseAmount();
        int purchaseAmountCount = lottoViewDto.getPurchaseAmountCount();

        lottoOutputView.printPurchaseAmountCount(purchaseAmount);
        List<Lotto> lottos = lottoModel.getRandomLottos(purchaseAmountCount);
        lottoOutputView.printLottos(lottos);

        lottoViewDto.setLottos(lottos);
    }

    private void inputWinningNumber(final LottoViewDto lottoViewDto) {
        lottoOutputView.printUserInputWinningNumber();
        List<Integer> winningNumbers = lottoInputView.inputWinningNumber(new WinningNumberValidation());

        lottoViewDto.setWinningNumbers(winningNumbers);
    }

    private void inputBonusNumber(final LottoViewDto lottoViewDto) {
        List<Integer> winningNumbers = lottoViewDto.getWinningNumbers();

        lottoOutputView.printUserInputBonusNumber();
        int bonusNumber = lottoInputView.inputBonusNumber(new BonusNumberValidation(), winningNumbers);

        lottoViewDto.setBonusNumber(bonusNumber);
    }

    private void printLottoResult(final LottoViewDto lottoViewDto) {
        List<Lotto> lottos = lottoViewDto.getLottos();
        List<Integer> winningNumbers = lottoViewDto.getWinningNumbers();
        int bonusNumber = lottoViewDto.getBonusNumber();

        List<LottoMatch> lottoMatches = lottoModel.getLottoMatches(lottos, winningNumbers, bonusNumber);
        LottoMatchCountDto lottoMatchCountDto = lottoModel.getLottoMatchCount(lottoMatches);
        lottoOutputView.printLottoResult(lottoMatchCountDto);

        lottoViewDto.setLottoMatches(lottoMatches);
    }

    private void printLottoRevenue(final LottoViewDto lottoViewDto) {
        List<LottoMatch> lottoMatches = lottoViewDto.getLottoMatches();
        int purchaseAmountCount = lottoViewDto.getPurchaseAmountCount();

        double lottoResultRevenue = lottoModel.calculateRevenue(lottoMatches, purchaseAmountCount);
        lottoOutputView.printLottoRevenue(lottoResultRevenue);
    }
}
