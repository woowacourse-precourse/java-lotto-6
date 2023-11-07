package lotto.view.component.output;

import lotto.controller.dto.output.LottosDrawingResult;
import lotto.view.component.Component;

public final class DrawingStatisticComponent implements Component {

    private static final String DRAWING_STATISTIC_MESSAGE = """
             
                    당첨 통계
                    ---
                    3개 일치 (5,000원) - %d개
                    4개 일치 (50,000원) - %d개
                    5개 일치 (1,500,000원) - %d개
                    5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                    6개 일치 (2,000,000,000원) - %d개
                    총 수익률은 %.1f%%입니다.
            """.replaceAll("( ){2,}", "");
    private final LottosDrawingResult data;

    public DrawingStatisticComponent(final LottosDrawingResult data) {
        this.data = data;
    }

    @Override
    public String render() {
        return String.format(
                DRAWING_STATISTIC_MESSAGE,
                data.fifthCount(),
                data.fourthCount(),
                data.thirdCount(),
                data.secondCount(),
                data.firstCount(),
                data.returnOfRate()
        );
    }
}
