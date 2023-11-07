package lotto.controller;

import static lotto.domain.LottoPrice.LOTTO_UNIT_PRICE;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.service.LottoIssueService;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.ErrorMessages;

public class LottoIssueController {
    private final LottoIssueService issueService;
    private final InputView input;
    private final OutputView output;

    public LottoIssueController() {
        this.issueService = new LottoIssueService();
        this.input = new InputView();
        this.output = new OutputView();
    }

    public Lottos issueLottos(int money) {
        validateMoney(money);
        int issueCount = calculateIssueCount(money);
        return issueService.issueLottos(issueCount);
    }

    public Lotto issueWinningLotto(List<Integer> winningNumber) {
        return issueService.issueWinningLotto(winningNumber);
    }

    public LottoResult issueLottoResult(Lotto winningLotto, int bonusNumber) {
        return new LottoResult(winningLotto, bonusNumber);
    }

    private int calculateIssueCount(final int money) {
        return money / LOTTO_UNIT_PRICE;
    }

    private void validateMoney(final int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_NOT_NEGATIVE.getMessage());
        }

        if (hasChange(money)) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_CANT_DIVIDE_ERROR.getMessage());
        }
    }

    private boolean hasChange(final int validMoney) {
        return validMoney % LOTTO_UNIT_PRICE != 0;
    }
}
