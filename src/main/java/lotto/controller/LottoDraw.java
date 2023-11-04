package lotto.controller;

import lotto.model.Customer;
import lotto.model.LottoWinning;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.view.constant.ConstantMessage.*;

public class LottoDraw {
    private Customer customer;
    private int numOfLotto;
    private LottoWinning lottoWinning;

    public LottoDraw() {}
    public void start() {
        // 로또 구입 금액을 입력
        OutputView.printConstantMessage(PAY_MONEY);
        customer = new Customer(InputView.requestPayMoney());
        OutputView.printNewLine();
        OutputView.println(String.valueOf(customer.getMoney()));
        OutputView.printNewLine();

        // 로또 발행
        numOfLotto = customer.getMoney() / LOTTO_PRICE.getLottoConstant();
        OutputView.printBuyLotto(BUY_LOTTO, numOfLotto);
        OutputView.printNewLine();
        for(int i = 0; i < numOfLotto ; i++) {
            customer.buyLotto();
        }
        OutputView.printLottos(customer);
        OutputView.printNewLine();

        // 당첨 번호 입력
        OutputView.printConstantMessage(WINNING_NUMBER);
        lottoWinning = new LottoWinning(InputView.requestWinnerNumber());
        OutputView.printNewLine();
        OutputView.printLottoWinning(lottoWinning.getWinningNumber());
        OutputView.printNewLine();

        // 보너스 번호 입력
        OutputView.printConstantMessage(BONUS_NUMBER);
        lottoWinning.initBonusNumber(InputView.requestBonusNumber());
        OutputView.printNewLine();
        OutputView.println(String.valueOf(lottoWinning.getBonusNumber()));
        OutputView.printNewLine();

        // 당첨 확인
        customer.calcWinningLotto(lottoWinning.getWinningNumber(), lottoWinning.getBonusNumber());
        OutputView.println(customer.getWinningLottos().toString());

        // 당첨 통계
        OutputView.printConstantMessage(WINNING_STATICS);
        OutputView.printWinningStatics(customer.getWinningLottos());

        // 총 수익률 계산
        customer.calcRateOfReturn();

        // 총 수익률 출력
        OutputView.printRateOfReturn(customer.getRateOrReturn());
    }
}
