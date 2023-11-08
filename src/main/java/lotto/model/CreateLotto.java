package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class CreateLotto {
    public Lotto createLotto() {
        CreateLottoNumber createLottoNumber = new CreateLottoNumber();
        return new Lotto(createLottoNumber.createLottoNumber());
    }

    public List<Lotto> createLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < purchaseAmount) {
            lottos.add(createLotto());
        }
        return lottos;
    }
}
