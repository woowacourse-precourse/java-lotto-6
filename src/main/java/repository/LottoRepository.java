package repository;

import domain.Lottos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {
    private Long id = 0L;
    private Long lotto_id = 0L;

    private final Map<Long, Lottos> userInputLottoList = new HashMap<>();
    private final Map<Long, List<List<Integer>>> all_lotto_list = new HashMap<>();

    public Long save(Lottos lotto_number) {
        userInputLottoList.put(id, lotto_number);
        id += 1;
        return id;
    }

    public Long lottoSave(List<List<Integer>> lottosList) {
        all_lotto_list.put(lotto_id, lottosList);
        lotto_id += 1;
        return lotto_id;
    }

    public List<Lottos> findAll() {
        return new ArrayList<>(userInputLottoList.values());
    }

}
