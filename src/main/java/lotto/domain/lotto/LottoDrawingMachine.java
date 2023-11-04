package lotto.domain.lotto;

import java.util.Optional;
import lotto.domain.lotto.dto.LottosDrawingResult;

/**
 * 로또 추첨을 해주는 클래스
 */
public final class LottoDrawingMachine {

    /**
     * 당첨 번호를 가지고 있는 WinningLotto
     */
    private final WinningLotto winningLotto;

    public LottoDrawingMachine(final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }


    /**
     * 입력된 모든 로또를 추첨한 결과 반환
     */
    public LottosDrawingResult draw(final Lottos lottos) {
        final LottoDrawingData data = new LottoDrawingData();
        _draw(data, lottos);

        return data.toLottoDrawingResult();
    }

    /**
     * 재귀 호출하며 중간 결과를 나타내는 LottoDrawingData에 모든 추첨 결과를 저장
     */
    private void _draw(
            final LottoDrawingData data,
            final Lottos lottos
    ) {
        final Optional<Lotto> lotto = lottos.nextLotto();

        if (lotto.isEmpty()) {
            return;
        }
        final LottoPrize lottoPrize = winningLotto.draw(lotto.get());
        data.save(lottoPrize);
        _draw(data, lottos);
    }

}
