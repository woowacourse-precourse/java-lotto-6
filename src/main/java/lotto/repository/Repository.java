package lotto.repository;

import java.util.List;
import java.util.Optional;
import lotto.domain.IndexModel;

public interface Repository<T extends IndexModel> {
    T save(T object);
    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteAll();
}