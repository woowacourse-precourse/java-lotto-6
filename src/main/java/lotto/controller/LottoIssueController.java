package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoIssueService;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.ErrorMessages;

public class LottoIssueController {
    private final static int UNIT_PRICE = 1000;
    private final LottoIssueService issueService;
    private final InputView input;
    private final OutputView output;

    public LottoIssueController() {
        this.issueService = new LottoIssueService();
        this.input = new InputView();
        this.output = new OutputView();
    }

    public List<Lotto> issueLottos(int money) {
        validateMoney(money);
        int issueCount = getIssueCount(money);
        return issueService.issueLottos(issueCount);
    }

    public Lotto issueWinningLotto(List<Integer> winningNumber) {
        return issueService.issueWinningLotto(winningNumber);
    }

    public WinningLotto issueLottoResult(Lotto winningLotto, int bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private int getIssueCount(final int money) {
        return money / UNIT_PRICE;
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
        return validMoney % UNIT_PRICE != 0;
    }
}
