package lotto;

import lotto.controller.LottoController;
import lotto.service.generator.LottoGenerator;
import lotto.service.LottoService;
import lotto.view.input.LottoInputView;
import lotto.view.output.LottoOutputView;
import lotto.view.output.component.NoticeComponent;
import lotto.view.output.component.PrintAllLottoComponent;
import lotto.view.output.component.PrintResultComponent;

public class AppConfig {

    public static LottoController setup() {
        return getLottoController();
    }

    private static LottoController getLottoController() {
        return new LottoController(
                getLottoService(),
                getLottoOutputView(),
                getLottoInputView()
        );
    }

    private static LottoService getLottoService() {
        return new LottoService(
                getLottoGenerator()
        );
    }

    private static LottoGenerator getLottoGenerator() {
        return new LottoGenerator();
    }

    private static LottoOutputView getLottoOutputView() {
        return new LottoOutputView(
                getNoticeComponent(),
                getPrintAllLottoComponent(),
                getPrintResultComponent()
        );
    }

    private static PrintResultComponent getPrintResultComponent() {
        return new PrintResultComponent();
    }

    private static PrintAllLottoComponent getPrintAllLottoComponent() {
        return new PrintAllLottoComponent();
    }

    private static NoticeComponent getNoticeComponent() {
        return new NoticeComponent();
    }

    private static LottoInputView getLottoInputView() {
        return new LottoInputView();
    }

}
