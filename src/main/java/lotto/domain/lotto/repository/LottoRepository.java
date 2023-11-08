package lotto.domain.lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

/**
 * 첫 입력으로 금액을 받아 구매한 모든 로또에 대한 저장소 클래스
 */
public final class LottoRepository {

    /**
     * 구매한 모든 Lotto를 List에 저장
     */
    private final List<Lotto> storage = new ArrayList<>();

    /**
     * 기본 생성자 명시
     */
    public LottoRepository() {
    }

    /**
     * 모든 Lotto를 저장
     */
    public void saveAll(final Lottos lottos) {
        while (lottos.isNotEmpty()) {
            final Lotto lotto = lottos.nextLotto().get();
            storage.add(lotto);
        }
    }

    /**
     * toList는 UnmodifiableList를 반환하며, 모든 Lotto를 clone(deepcopy) 하여 storage에 저장된 데이터에 영향이 가지 않도록 모든 데이터를 사본이자 불변으로 반환함
     */
    public List<Lotto> findAll() {
        return storage.stream()
                .map(Lotto::clone)
                .toList();
    }
}
