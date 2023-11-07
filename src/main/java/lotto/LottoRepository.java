package lotto;

import java.util.HashMap;

public class LottoRepository {
    private final HashMap<Integer, Lotto> slot = new HashMap<>();
    private int id = 0;

    public void save(Lotto lotto) {
        slot.put(id, lotto);
        id++;
    }

    public HashMap<Integer, Lotto> getAllLotto() {
        return slot;
    }
}
