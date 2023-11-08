package lotto.domain;

import java.util.List;
import lotto.Util.GenerateRandomLotto;
import lotto.Util.Profit;
import lotto.view.OutputView;

public class LottoController {

    private LottoController() {
        List<Lotto> autoLotto = showAutoLottoList();
        WinnigNumber winnigNumber = setWinningNumber();
        Result result = Result.of(autoLotto, winnigNumber);

        showResult(result);
        showProfit(result, autoLotto);
    }

    public static LottoController activate() {
        return new LottoController();
    }

    //구매 가격 입력, 로또 자동 생성
    //구매한 로또 갯수 출력, 자동 생성된 로또 출력
    private List<Lotto> showAutoLottoList() {
        GenerateRandomLotto generateRandomLotto = new GenerateRandomLotto();
        generateRandomLotto.printAmount();
        List<Lotto> autoLotto = generateRandomLotto.getLottoList();
        OutputView.printAutoLottoList(autoLotto);
        return autoLotto;
    }

    //당첨 번호와 보너스 번호 세팅
    private WinnigNumber setWinningNumber() {
        return DrawLotto.draw();
    }

    //결과 생성
    public void showResult(Result result) {
        OutputView.printLottoResult(result);
    }

    public void showProfit(Result result, List<Lotto> autoLotto) {
        OutputView.printProfit(Profit.getProfit((float) result.getPrize(), (float) autoLotto.size() * 1000));
    }
}
