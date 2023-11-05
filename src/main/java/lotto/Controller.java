package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Lotto> lottoTickets = new ArrayList<>();
    Input input = new Input();
    Output output = new Output();
    LottoValidation lottoValidation = new LottoValidation();
    LottoChecker lottoChecker = new LottoChecker();
    Calculator calculator = new Calculator();
    LottoMachine lottoMachine = new LottoMachine();

    public void lottoStart() {
        output.notifyPayment();
        int count = lottoMachine.getLottoCount(input.getUserMoney());
        output.notifyLottoCount(count);
        purchaseLotto(count);

        output.notifyWinningNumbers();
        List<Integer> inputNumber = input.getWinningLottoNumber();
        checkLotto(inputNumber);
        Lotto winningNumber = new Lotto(inputNumber);

        int bonusNumber = input.getBonusNumber();
        checkBonusNumber(inputNumber, bonusNumber);

        List<Integer> result = lottoChecker.lottoResult(
                lottoChecker.compareLottoTickets(lottoTickets, winningNumber, bonusNumber));
        output.notifyWinningDetails(result);

        float profitRate = calculator.rateOFProfit(result, count);
        output.notifyProfitRate(profitRate);
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void purchaseLotto(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(getRandomNumbers());
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
        if (!lottoValidation.checkLottoNumberRange(winningNumber, 1, 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        if (!lottoValidation.checkDuplicateLottoNumber(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호 입니다.");
        }
    }

    public void checkBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        if (!lottoValidation.checkBonusNumberRange(bonusNumber, 1, 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        if (!lottoValidation.checkDuplicateBonusNumber(winningNumber, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 보너스 번호 입니다.");
        }
    }
}