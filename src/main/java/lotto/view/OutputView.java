package lotto.view;

import io.output.Writer;
import lotto.controller.dto.output.LottosBuyingResult;
import lotto.controller.dto.output.LottosDrawingResult;
import lotto.view.component.output.BoughtLottosCountComponent;
import lotto.view.component.output.DrawingStatisticComponent;
import lotto.view.component.output.LottoNumbersComponent;

/**
 * 실행 결과 데이터 Dto를 가공하여
 * <p>
 * 출력을 위한 문자열로 렌더링 한 뒤,
 * <p>
 * 최종 목적지로 출력하는 역할을 담당합니다.
 */
public final class OutputView {

    /**
     * Console이 아닌 네트워크, 파일 쓰기 등으로 교체가 가능하도록
     * <p>
     * 인터페이스에 의존합니다.
     */
    private final Writer writer;

    public OutputView(final Writer writer) {
        this.writer = writer;
    }

    /**
     * 로또 구매 시, 구매한 로또 개수 및 모든 로또의 번호를 출력합니다.
     */
    public void printLottosBuyingResult(final LottosBuyingResult data) {
        new BoughtLottosCountComponent(data)
                .compose(new LottoNumbersComponent(data))
                .renderTo(writer);
    }

    /**
     * 구매한 로또의 추첨 결과를 당첨 번호 및 보너스 번호와 비교하여
     * <p>
     * 수익률, 등수 별 장 수를 출력합니다.
     */
    public void printLottosDrawingResult(final LottosDrawingResult data) {
        new DrawingStatisticComponent(data).renderTo(writer);
    }
}
