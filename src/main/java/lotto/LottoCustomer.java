package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.console.LottoInputConsole;
import lotto.console.LottoOutputConsole;
import lotto.policy.LottoNumbersGenerator;
import lotto.util.StringUtil;
import lotto.validator.LottoValidator;

public class LottoCustomer {
    private final LottoInputConsole lottoInputConsole;
    private final LottoOutputConsole lottoOutputConsole;
    private final LottoStore lottoStore;

    public LottoCustomer() {
        this.lottoInputConsole = new LottoInputConsole();
        this.lottoOutputConsole = new LottoOutputConsole();
        this.lottoStore = new LottoStore(() -> Randoms.pickUniqueNumbersInRange(
                LottoNumbersGenerator.MIN_NUMBER,
                LottoNumbersGenerator.MAX_NUMBER,
                LottoNumbersGenerator.NUMBER_COUNT
        ));
    }

    public void buy() {
        Amount purchaseAmount = readyMoney();
        SoldLotto soldLotto = buyLottoTickets(purchaseAmount);
        WinningLotto winningLotto = getWinningLotto();
        confirmLottoOutcome(purchaseAmount, soldLotto, winningLotto);
    }

    private void confirmLottoOutcome(Amount purchaseAmount, SoldLotto soldLotto, WinningLotto winningLotto) {
        List<LottoRanking> lottoRankings = soldLotto.checkLottoResults(winningLotto);
        double returnRate = SoldLotto.getReturnRate(purchaseAmount, lottoRankings);
        lottoOutputConsole.printLottoResults(lottoRankings, returnRate);
    }

    private Amount readyMoney() {
        while (true) {
            try {
                Amount purchaseAmount = lottoInputConsole.readPurchaseAmount();
                LottoValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private SoldLotto buyLottoTickets(Amount purchaseAmount) {
        SoldLotto soldLotto = lottoStore.sell(purchaseAmount);
        lottoOutputConsole.printSoldLotto(soldLotto);
        return soldLotto;
    }

    private WinningLotto getWinningLotto() {
        List<Integer> validatedWinningLottoNumbers = getValidatedWinningLottoNumbers();
        int bonusNumber = getValidatedBonusNumber(validatedWinningLottoNumbers);
        return new WinningLotto(validatedWinningLottoNumbers, bonusNumber);
    }

    private int getValidatedBonusNumber(List<Integer> validatedWinningLottoNumbers) {
        while (true) {
            try {
                int bonusNumber = lottoInputConsole.readBonusNumber();
                LottoValidator.validateBonusNumber(bonusNumber, validatedWinningLottoNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private List<Integer> getValidatedWinningLottoNumbers() {
        while (true) {
            try {
                String winningLottoNumbers = lottoInputConsole.readWinningLottoNumbers();
                LottoValidator.validateWinningLottoNumbers(winningLottoNumbers);
                return StringUtil.splitAndParseToIntList(winningLottoNumbers);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }
}
