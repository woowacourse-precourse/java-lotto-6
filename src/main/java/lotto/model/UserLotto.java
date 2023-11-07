package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

    private List<Lotto> lottoGroup = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottoGroup.add(lotto);
    }

}
