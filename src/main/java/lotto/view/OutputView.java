package lotto.view;

import component.Composer;
import component.output.BoughtLottosCountComponent;
import component.output.DrawingStatisticComponent;
import io.input.Writer;
import lotto.controller.dto.LottosBuyingResult;
import lotto.controller.dto.LottosDrawingResult;

public final class OutputView {

    private final Composer composer;

    private final Writer writer;

    public OutputView(
            final Writer writer,
            final Composer composer
    ) {
        this.writer = writer;
        this.composer = composer;
    }

    public void printLottosBuyingResult(final LottosBuyingResult result) {
        final String composedMessage = composer.renderAll(
                new BoughtLottosCountComponent(result.count())
        );
        writer.write(composedMessage);
    }

    public void printLottosDrawingResult(final LottosDrawingResult result) {
        writer.write(new DrawingStatisticComponent(result).render());
    }
}
