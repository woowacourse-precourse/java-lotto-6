package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Buyer;
import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.PurchasingMoney;
import lotto.model.WinningLotto;
import lotto.model.WinningNumbers;
import lotto.model.dto.LottoPaper;
import lotto.model.dto.LottoResult;
import lotto.utils.LottoNumberValidator;
import lotto.utils.NumberParser;
import lotto.view.InputView;
import lotto.view.OuputView;

public class LottoController {
    private final static String DELIMETER = ",";

    private final InputView inputView;
    private final OuputView ouputView;
    private final LottoSeller lottoSeller = new LottoSeller();

    public LottoController(InputView inputView, OuputView ouputView) {
        this.inputView = inputView;
        this.ouputView = ouputView;
    }

    public void run() {
        final Buyer lottoBuyer = buyLotto();
        final List<LottoPaper> lottoPapers = lottoBuyer.getLottoPapers();

        ouputView.printPublishedLottos(lottoPapers);

        final WinningLotto winningLotto = pickWinningLotto();
        final LottoResult lottoResult = lottoBuyer.createLottoResult(winningLotto);

        ouputView.printLottoResult(lottoResult);
    }

    private WinningLotto pickWinningLotto() {
        final WinningNumbers winningNumbers = inputNumbers();
        final Integer bonusNumber = inputBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Integer inputBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                Integer bonusNumber = NumberParser.parse(inputBonusNumber);
                LottoNumberValidator.validateNumber(bonusNumber);
                winningNumbers.validateDuplicateNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                handleException(e);
            }
        }
    }

    private WinningNumbers inputNumbers() {
        while (true) {
            try {
                String inputNumbers = inputView.inputNumbers();
                List<Integer> convertedNumbers = convertToNumbers(inputNumbers);
                return WinningNumbers.createWinningNumbers(convertedNumbers);
            } catch (IllegalArgumentException e) {
                handleException(e);
            }
        }
    }

    private List<Integer> convertToNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(DELIMETER))
                .map(NumberParser::parse)
                .collect(Collectors.toList());
    }

    private Buyer buyLotto() {
        final Money purchasingMoney = inputMoney();
        final Lottos publishedLottos = lottoSeller.sell(purchasingMoney);
        return new Buyer(purchasingMoney, publishedLottos);
    }

    private Money inputMoney() {
        while (true) {
            try {
                String inputMoney = inputView.insertMoney();
                return new PurchasingMoney(inputMoney);
            } catch (IllegalArgumentException e) {
                handleException(e);
            }
        }
    }

    private void handleException(Exception e) {
        String errorMessage = e.getMessage();
        ouputView.printErrorMessage(errorMessage);
    }
}
