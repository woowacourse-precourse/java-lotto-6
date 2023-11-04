package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.utils.Utills;

public class LottoService {

    private void buyLotto(User user){
        Lotto lotto = generateLottoNumber();
        user.addLotto(lotto);
    }
    private Lotto generateLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Utills.randomUniqueNumbers(6, 1, 45));
        return new Lotto(lottoNumbers);
    }
}
