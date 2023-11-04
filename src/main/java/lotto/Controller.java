package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoValidation;
import lotto.ui.Input;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Lotto> lottoTickets = new ArrayList<>();
    Input input = new Input();
    LottoValidation lottoValidation = new LottoValidation();

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

    public void checkLotto() {
        if (!lottoValidation.checkLottoNumberRange(input.getWinningLottoNumber(), 1, 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        if (!lottoValidation.checkDuplicateLottoNumber(input.getWinningLottoNumber())) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호 입니다.");
        }
    }
}