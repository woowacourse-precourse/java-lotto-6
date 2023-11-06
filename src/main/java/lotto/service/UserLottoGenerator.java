package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.UserLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoGenerator {

    public List<UserLotto> generateUserLotto(int lottoTicket) {
        List<UserLotto> userLottos = new ArrayList<>();
        for (int i = 0; i < lottoTicket; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            UserLotto userLotto = new UserLotto(numbers);
            userLottos.add(userLotto);
        }
        return userLottos;
    }
}
