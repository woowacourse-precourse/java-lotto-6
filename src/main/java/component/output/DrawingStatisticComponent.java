package component.output;

import component.Component;
import lotto.controller.dto.LottosDrawingResult;

public final class DrawingStatisticComponent implements Component {

    private static final String HEADER = "\n당첨 통계\n---\n";
    private static final String FIRST_LINE = "3개 일치 (5,000원) - %d개\n";
    private static final String SECOND_LINE = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_LINE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String FOURTH_LINE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIFTH_LINE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String FOOTER = "총 수익률은 %.1f%%입니다.\n";
    private final LottosDrawingResult data;

    public DrawingStatisticComponent(final LottosDrawingResult data) {
        this.data = data;
    }

    @Override
    public String render() {
        return String.format(
                HEADER + FIRST_LINE + SECOND_LINE + THIRD_LINE + FOURTH_LINE + FIFTH_LINE + FOOTER,
                data.fifthCount(),
                data.fourthCount(),
                data.thirdCount(),
                data.secondCount(),
                data.firstCount(),
                data.returnOfRate()
        );
    }
}
