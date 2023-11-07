package lotto.dao;

import lotto.Lotto;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LottoRepository {

    private final ConcurrentMap<String, List<Lotto>> repository;


    public LottoRepository() {
        repository = new ConcurrentHashMap<>();
    }

    public Optional<List<Lotto>> findByKey(String key) {
        return Optional.ofNullable(repository.get(key));
    }

    public void save(String key, List<Lotto> lotto) {
        repository.put(key, lotto);
    }


}
