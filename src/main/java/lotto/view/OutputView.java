package lotto.view;

import component.output.BoughtLottosCountComponent;
import component.output.DrawingStatisticComponent;
import component.output.LottoNumbersComponent;
import io.output.Writer;
import lotto.controller.dto.output.LottosBuyingResult;
import lotto.controller.dto.output.LottosDrawingResult;

public final class OutputView {

    private final Writer writer;

    public OutputView(final Writer writer) {
        this.writer = writer;
    }

    public void printLottosBuyingResult(final LottosBuyingResult data) {
        new BoughtLottosCountComponent(data)
                .compose(new LottoNumbersComponent(data))
                .renderTo(writer);
    }

    public void printLottosDrawingResult(final LottosDrawingResult data) {
        new DrawingStatisticComponent(data).renderTo(writer);
    }
}
