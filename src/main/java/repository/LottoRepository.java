package repository;

import domain.Lottos;

import java.util.HashMap;
import java.util.Map;

public class LottoRepository {
    private Long id = 0L;

    private final Map<Long, Lottos> userLottoList = new HashMap<>();

    public Long save(Lottos lotto_number) {
        userLottoList.put(id, lotto_number);
        id += 1;
        return id;
    }
}
