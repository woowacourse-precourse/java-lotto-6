package lotto.domain.lotto;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

/**
 * 사용자가 구매한 모든 로또를 담는 일급 컬렉션입니다.
 */
public final class Lottos {
    /**
     * 사용자가 구매한 로또 리스트
     */
    private final Deque<Lotto> lottos;

    /**
     * 이미 Lotto를 만들 때, LottoNumber가 1~45 범위에 속하는지, 6자리 숫자인지 검증이 끝난 상태이기 때문에 별도의 검증 없이 생성합니다.
     */
    public Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayDeque<>(lottos);
    }

    public Optional<Lotto> nextLotto() {
        return Optional.ofNullable(lottos.poll());
    }

    public int size() {
        return lottos.size();
    }
}
