package lotto.view.component.output;

import lotto.controller.dto.output.LottosBuyingResult;
import lotto.view.component.Component;
import lotto.view.component.Composable;

/**
 * 로또를 몇 개 구매했는지 보여주는 메세지를 렌더링하는 Component입니다.
 */
public final class BoughtLottosCountComponent implements Component, Composable {
    /**
     * 메세지 템플릿
     */
    private static final String BOUGHT_LOTTOS_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";

    /**
     * 구매한 로또 개수,
     * <p>
     * 출력이 발생할 때마다 Component가 새로 생성되며,
     * <p>
     * 그 때마다 구매한 로또 개수를 새로 받아서 생성하기 때문에, 항상 렌더링 결과가 바뀌게 됩니다.
     */
    private final int lottosCount;

    public BoughtLottosCountComponent(final LottosBuyingResult data) {
        this.lottosCount = data.count();
    }

    /**
     * Dto로부터 로또가 몇 개를 구매했는지 정보를 받아서 메세지 템플릿의 `%d`를 데이터로 채워서 문자열로 렌더링합니다.
     * <p>
     * 렌더링 된 문자열은 비즈니스 로직에 대한 처리 결과이므로, `OutputView`에서 출력됩니다.
     */
    @Override
    public String render() {
        return String.format(BOUGHT_LOTTOS_COUNT_MESSAGE, lottosCount);
    }

    /**
     * 다른 컴포넌트와 내용을 연결하는 익명 Component 생성 가능
     */
    @Override
    public Component compose(final Component other) {
        return () -> render() + other.render();
    }

}
