package lotto.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Buyer;
import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinnigLotto;
import lotto.model.WinningNumbers;
import lotto.model.dto.LottoPaper;
import lotto.model.dto.LottoResult;
import lotto.utils.LottoNumberValidator;
import lotto.utils.MoneyParser;
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

        final WinnigLotto winnigLotto = pickWinningLotto();
        final LottoResult lottoResult = lottoBuyer.createLottoResult(winnigLotto);

        ouputView.printLottoResult(lottoResult);
    }

    private WinnigLotto pickWinningLotto() {
        final WinningNumbers winningNumbers = inputNumbers();
        final Integer bonusNubmer = inputBonusNubmer(winningNumbers);
        return new WinnigLotto(winningNumbers, bonusNubmer);
    }

    private Integer inputBonusNubmer(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                Integer bonusNumber = NumberParser.parse(inputBonusNumber);
                LottoNumberValidator.validate(bonusNumber);
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
                BigDecimal parsedMoney = MoneyParser.parseMoney(inputMoney);
                return new Money(parsedMoney);
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
