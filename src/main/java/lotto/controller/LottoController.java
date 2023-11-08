package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.ComputeLottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoFactory;
import lotto.domain.Price;
import lotto.domain.PrizeStatisticsCalculator;
import lotto.domain.Quantity;
import lotto.domain.ReturnOnInvestmentCalculator;
import lotto.view.InputValidator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {


    public static final int LOTTO_PRICE = 1000;
    private final LottoInputView lottoInputView;

    private final LottoOutputView lottoOutputView;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
    }

    // 가격을 입력받아 복권 갯수만큼 복권 출력
    private List<Lotto> executePayment() {
        final Price price = InputValidator.getValidInput(lottoInputView::priceInfoLog,
                () -> new Price(Console.readLine()));
        final Quantity quantity = InputValidator.getValidInput(() -> new Quantity(price));
        lottoOutputView.purchaseInfoLog(quantity.getQuantity());
        List<Lotto> generatorLottoList = new ComputeLottoGenerator(quantity).generatorLottoList();
        generatorLottoList.forEach(generatorLotto -> System.out.println(generatorLotto.getNumbers()));
        return generatorLottoList;
    }

    // 로또번호 + 보너스 번호 입력받기
    private Lotto enterLottoNumber() {
        Lotto lotto = InputValidator.getValidInput(lottoInputView::initLottoNumberLog,
                () -> LottoFactory.createLottoFrom(Console.readLine()));
        LottoBonusNumber lottoBonusNumber = InputValidator.getValidInput(lottoInputView::initLottoBonusNumberLog,
                () -> LottoBonusNumber.validateLottoNumDuplicate(lotto, new LottoBonusNumber(Console.readLine())));
        lotto.getNumbers().add(lottoBonusNumber.getBonusNumber());
        return lotto;
    }

    public void initLottoGame() {
        List<Lotto> lottoList = executePayment();
        Lotto winningLotto = enterLottoNumber();
        long totalProfit = 0;
        int investment = lottoList.size() * LOTTO_PRICE;
        lottoOutputView.showStatisticLog();

        for (PrizeStatisticsCalculator prize : PrizeStatisticsCalculator.values()) {
            prize.printMatchCount(lottoList, winningLotto);
            long prizeMoney = ReturnOnInvestmentCalculator.calculateTotalProfit(prize, lottoList, winningLotto);
            totalProfit += prizeMoney;
        }

        double profitRate = ReturnOnInvestmentCalculator.calculateProfitRate(totalProfit, investment);
        lottoOutputView.showResultLog(profitRate);
    }


}