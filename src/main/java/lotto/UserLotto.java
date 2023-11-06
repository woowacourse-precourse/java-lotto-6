package lotto;

import static lotto.Util.generateNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {

    private List<Lotto> userLottos;

    public UserLotto(int lottoCount) {
        createLotto(lottoCount);
    }

    private void createLotto(int lottoCount) {
        userLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateNumbers();
            Collections.sort(lottoNumbers);
            userLottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }
}
