package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStorage {

    private static List<Lotto> lottoStorage = new ArrayList<>();

    public static void addLotto(Lotto lotto) {
        lottoStorage.add(lotto);
    }

    public static List<Lotto> getLotto() {
        return lottoStorage;
    }

}
