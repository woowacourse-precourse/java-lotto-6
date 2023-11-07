package lotto.controller;

import lotto.model.Customer;
import lotto.model.LottoWinning;
import lotto.validation.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

import static java.lang.Integer.parseInt;
import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.view.constant.ConstantMessage.*;

public class LottoDraw {
    private Customer customer;
    private int numOfLotto;
    private LottoWinning lottoWinning;

    public LottoDraw() {}
    public void start() {
        // 로또 구입 금액을 입력
        if (payLottoAmount()) return;

        // 로또 발행
        numOfLotto = customer.getMoney() / LOTTO_PRICE.getLottoConstant();
        OutputView.printBuyLotto(BUY_LOTTO, numOfLotto);
        for(int i = 0; i < numOfLotto ; i++) {
            customer.buyLotto();
        }
        OutputView.printLottos(customer);

        // 당첨 번호 입력
        OutputView.printConstantMessage(WINNING_NUMBER);
        lottoWinning = new LottoWinning(InputView.requestWinnerNumber());
        OutputView.printLottoWinning(lottoWinning.getWinningNumber());

        // 보너스 번호 입력
        OutputView.printConstantMessage(BONUS_NUMBER);
        lottoWinning.initBonusNumber(InputView.requestBonusNumber());
        OutputView.println(String.valueOf(lottoWinning.getBonusNumber()));

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

    private boolean payLottoAmount() {
        // 로또 구입 금액을 입력
        OutputView.printConstantMessage(PAY_MONEY);
        String pay = InputView.requestPayMoney();
        if (validationPayAmount(pay)) {
            return true;
        }

        customer = new Customer(parseInt(pay));
        OutputView.println(String.valueOf(customer.getMoney()));
        return false;
    }

    private boolean validationPayAmount(String pay) {
        if (Validator.checkIsNotNumber(pay)) {
            OutputView.printError(ErrorMessage.PAY_NOT_NUMBER.getMessage());
            return true;
        }

        if (Validator.checkIsZero(parseInt(pay))) {
            OutputView.printError(ErrorMessage.PAY_IS_ZERO.getMessage());
            return true;
        }

        if (Validator.checkMultipleOf1000(parseInt(pay))) {
            OutputView.printError(ErrorMessage.PAY_NOT_MULTIPLE_OF_1000.getMessage());
        }
        return false;
    }

}
