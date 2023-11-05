package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoValidation;
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

    public void lottoStart() {
        output.notifyPayment();
        int count = getLottoCount(input.getUserMoney());
        purchaseLotto(count);
        output.notifyLottoCount(lottoTickets);
        for (int i = 0; i < count; i++) {
            output.notifyLottoNumbers(lottoTickets.get(i).getNumbers());
        }
        output.notifyWinningNumbers();
        List<Integer> inputNumber = input.getWinningLottoNumber();
        checkLotto(inputNumber);
        Lotto winningNumber = new Lotto(inputNumber);
        System.out.println();
        int bonusNumber = input.getBonusNumber();
        checkBonusNumber(inputNumber, bonusNumber);
        System.out.println();
        List<Integer> counts = lottoChecker.compareLottoTickets(lottoTickets, winningNumber, bonusNumber);
        List<Integer> result = lottoChecker.lottoResult(counts);
        output.notifyWinningDetails(result);
        float profitRate = calculator.rateOFProfit(result, count);
        output.notifyProfitRate(profitRate);
    }

    public int getLottoCount(int userMoney) {
        if (userMoney % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }

        return userMoney / Lotto.PRICE;
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void purchaseLotto(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(getRandomNumbers());
            lottoTickets.add(lotto);
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