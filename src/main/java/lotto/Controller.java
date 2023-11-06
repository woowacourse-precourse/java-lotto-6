package lotto;

import lotto.domain.*;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Lotto> lottoTickets = new ArrayList<>();
    Input input = new Input();
    Output output = new Output();
    LottoChecker lottoChecker = new LottoChecker();
    Calculator calculator = new Calculator();
    LottoMachine lottoMachine = new LottoMachine();

    public void lottoStart() {
        output.notifyPayment();
        int count = lottoMachine.getLottoCount(input.getUserMoney());
        output.notifyLottoCount(count);
        purchaseLotto(count);
    }

    public void getWinningNumberBonusNumber() {
        output.notifyWinningNumbers();
        List<Integer> inputNumber = input.getWinningLottoNumber();
        checkLotto(inputNumber);
        Lotto winningNumber = new Lotto(inputNumber);

        int bonusNumber = input.getBonusNumber();
        checkBonusNumber(inputNumber, bonusNumber);

        giveLottoResult(winningNumber, bonusNumber);
    }

    public void giveLottoResult(Lotto winningNumber, int bonusNumber) {
        List<Integer> result = lottoChecker.lottoResult(lottoChecker
                .compareLottoTickets(lottoTickets, winningNumber, bonusNumber));
        output.notifyWinningDetails(result);

        float profitRate = calculator.rateOFProfit(result, lottoTickets.size());
        output.notifyProfitRate(profitRate);
    }

    public void purchaseLotto(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(lottoMachine.getRandomNumbers());
            lottoTickets.add(lotto);
        }

        for (int i = 0; i < count; i++) {
            output.notifyLottoNumbers(lottoTickets.get(i).getNumbers());
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public void checkLotto(List<Integer> winningNumber) {
        if (!lottoChecker.checkLottoNumberRange(winningNumber, 1, 45)) {
            throw new IllegalArgumentException(Output.MUST_BE_NUMBERS_BETWEEN_1_45_ERROR);
        }
        if (!lottoChecker.checkDuplicateLottoNumber(winningNumber)) {
            throw new IllegalArgumentException(Output.HAS_DUPLICATE_NUMBER_ERROR);
        }
    }

    public void checkBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        if (!lottoChecker.checkBonusNumberRange(bonusNumber, Lotto.MIN_VALUE, Lotto.MAX_VALUE)) {
            throw new IllegalArgumentException(Output.MUST_BE_BONUS_NUMBER_BETWEEN_1_45_ERROR);
        }
        if (!lottoChecker.checkDuplicateBonusNumber(winningNumber, bonusNumber)) {
            throw new IllegalArgumentException(Output.HAS_DUPLICATE_NUMBER_ERROR);
        }
    }
}