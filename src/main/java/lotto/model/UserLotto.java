package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto { // LottoStorage

    private static List<Lotto> lottoGroup = new ArrayList<>();

    public static void addLotto(Lotto lotto) {
        lottoGroup.add(lotto);
    }

}
