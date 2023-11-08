package lotto.view.output;

import lotto.controller.dto.LottoDtos;
import lotto.service.dto.GameResult;
import lotto.view.output.component.NoticeComponent;
import lotto.view.output.component.PrintAllLottoComponent;
import lotto.view.output.component.PrintResultComponent;

public class LottoOutputView {

    private final NoticeComponent noticeComponent;
    private final PrintAllLottoComponent printAllLottoComponent;
    private final PrintResultComponent printResultComponent;


    public LottoOutputView(
            final NoticeComponent noticeComponent,
            final PrintAllLottoComponent printAllLottoComponent,
            final PrintResultComponent printResultComponent)
    {
        this.noticeComponent = noticeComponent;
        this.printAllLottoComponent = printAllLottoComponent;
        this.printResultComponent = printResultComponent;
    }

    public void askPurchasePrice() {
        noticeComponent.askPurchasePrice();
    }

    public void askLottoNumbers() {
        noticeComponent.askLottoNumbers();
    }

    public void askLottoBonusNumber() {
        noticeComponent.askLottoBonusNumber();
    }

    public void printLottos(final LottoDtos lottoDtos) {
        printAllLottoComponent.printLottos(lottoDtos);
    }

    public void printResult(final GameResult gameResult) {
        printResultComponent.printResult(gameResult);
    }
}
