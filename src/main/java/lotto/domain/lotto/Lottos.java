package lotto.domain.lotto;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import lotto.domain.lotto.opened.LottoOpened;
import lotto.domain.lotto.opened.LottosOpened;

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

    /**
     * ArrayDeque<Lotto>에 들어 있는 Lotto를 순차적으로 하나씩 빼서 반환합니다.
     */
    public Optional<Lotto> nextLotto() {
        return Optional.ofNullable(lottos.poll());
    }

    /**
     * 원본 Lottos와 하위 멤버들을 새로이 deepcopy하여 새로운 객체를 반환합니다.
     */
    public Lottos clone() {
        final List<Lotto> nextLottos = this.lottos.stream()
                .map(Lotto::clone)
                .toList();

        return new Lottos(nextLottos);
    }

    public int size() {
        return lottos.size();
    }

    public boolean isNotEmpty() {
        return !lottos.isEmpty();
    }

    public LottosOpened toOpened() {
        final List<LottoOpened> lottoOpeneds = lottos.stream()
                .map(Lotto::toOpened)
                .toList();
        return new LottosOpened(lottoOpeneds);
    }
}
