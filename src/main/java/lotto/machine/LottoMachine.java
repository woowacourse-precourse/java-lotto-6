package lotto.machine;

import lotto.constant.LottoValue;
import lotto.constant.Prize;
import lotto.lotto.controller.LottoController;
import lotto.statistic.controller.StatisticController;
import lotto.view.controller.ViewController;

import java.util.List;

public class LottoMachine {

    private final ViewController viewController;
    private final LottoController lottoController;
    private final StatisticController statisticController;
    private int purchaseAmount;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoMachine(ViewController viewController, LottoController lottoController, StatisticController statisticController) {
        this.viewController = viewController;
        this.lottoController = lottoController;
        this.statisticController = statisticController;
        start();
    }

    public void start() {
        // 구매 금액 입력
        setPurchaseAmount(viewController.inputPurchaseAmount());
        // 랜덤 로또 발행
        lottoController.createRandomLottos(getPurchaseAmount() / LottoValue.UNIT);
        // 발행된 로또 출력
        viewController.printRandomLottos(lottoController.getRandomLottos());
        // 당첨 번호 입력
        setWinningNumbers(viewController.inputWinnerNumbers());
        // 보너스 번호 입력 및 저장
        setBonusNumber(viewController.inputBonusNumber(getWinningNumbers()));
        // 당첨 통계 생성
        statisticController.generate(lottoController.getRandomLottos(), getWinningNumbers(), getBonusNumber());
        // 당첨 통계 출력
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
