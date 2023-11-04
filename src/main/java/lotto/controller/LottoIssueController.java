package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoIssueService;
import lotto.ui.InputView;
import lotto.ui.OutputView;

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

    public List<Lotto> issueLottos() {
        int validCount = getValidCount();
        return issueService.issueLottos(validCount);
    }

    private int getValidCount() {
        int validMoney = 0;
        while (validMoney == 0) {
            try {
                int inputMoney = input.inputMoney();
                validMoney = validateMoney(inputMoney);
            } catch (IllegalArgumentException e) {
                output.printInvalidateMoneyStatement();
            }
        }
        return validMoney / UNIT_PRICE;
    }

    private int validateMoney(final int validMoney) {
        if (validMoney < 0)
            throw new IllegalArgumentException();

        if (isNotRemainedMoney(validMoney))
            throw new IllegalArgumentException();

        return validMoney;
    }

    private boolean isNotRemainedMoney(final int validMoney) {
        return validMoney % UNIT_PRICE != 0;
    }
}
