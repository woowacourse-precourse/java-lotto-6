package lotto.repository;

import java.util.Optional;
import lotto.constant.ErrorMessage;

public class DomainRepository<T> {

    private T domain;

    public void save(final T domain) {
        this.domain = domain;
    }

    public T get() {
        return Optional.ofNullable(domain)
                .orElseThrow(
                        () -> new IllegalStateException(ErrorMessage.NOT_INITIALIZED.toValue()));
    }
}
