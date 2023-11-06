package lotto.repository;

import lotto.entity.LottoGame;

import java.util.HashMap;
import java.util.Map;

public class LottoGameRepository {
    public LottoGameRepository() {
        this.id = 0l;
    }

    private Map<Long, LottoGame> userDB = new HashMap<Long, LottoGame>();
    private Long id;
    public Long save(LottoGame saveLottoGame) {
        saveLottoGame.setId(id);
        userDB.put(id, saveLottoGame);
        return id++;
    }

    public LottoGame findById(Long lottoGameId) {
        return userDB.get(lottoGameId);
    }
}
