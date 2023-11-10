package lotto.common.config;

import lotto.controller.LottoController;
import lotto.io.reader.ConsoleReader;
import lotto.io.reader.Reader;
import lotto.io.writer.ConsoleWriter;
import lotto.io.writer.Writer;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoWinningStatisticsService;
import lotto.service.generator.AutoLottoNumberGenerator;
import lotto.service.generator.LottoNumberGenerator;
import lotto.view.LottoView;

public class LottoConfig {
    public LottoController getLottoController() {
        LottoView lottoView = getLottoView(getReader(), getWriter());
        LottoPurchaseService lottoPurchaseService = getLottoPurchaseService(getLottoNumberGenerator());
        LottoWinningStatisticsService lottoWinningStatisticsService = getLottoWinningResultService();
        return new LottoController(lottoPurchaseService, lottoWinningStatisticsService, lottoView);
    }

    private Reader getReader() {
        return new ConsoleReader();
    }

    private Writer getWriter() {
        return new ConsoleWriter();
    }

    private LottoView getLottoView(Reader reader, Writer writer) {
        return new LottoView(reader, writer);
    }

    private LottoNumberGenerator getLottoNumberGenerator() {
        return new AutoLottoNumberGenerator();
    }

    private LottoPurchaseService getLottoPurchaseService(LottoNumberGenerator lottoNumberGenerator) {
        return new LottoPurchaseService(lottoNumberGenerator);
    }

    private LottoWinningStatisticsService getLottoWinningResultService() {
        return new LottoWinningStatisticsService();
    }
}
