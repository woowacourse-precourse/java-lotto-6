package lotto.controller;

import lotto.model.Customer;
import lotto.model.LottoWinning;
import lotto.model.WinningEnquiry;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.constant.LottoConstant.*;
import static lotto.view.constant.ConstantMessage.*;

public class LottoDraw {
    private Customer customer;
    private int numOfLotto;
    private LottoWinning lottoWinning;
    private WinningEnquiry winningEnquiry;

    public LottoDraw() {
        winningEnquiry = new WinningEnquiry();
    }
    public void start() {
        // 로또 구입 금액을 입력
        payLottoAmount();

        // 로또 발행
        issueLotto();

        // 당첨 번호 입력
        inputWinningNumber();

        // 보너스 번호 입력
        inputBonusNumber();

        // 당첨 확인
        winningEnquiry.calculateWinningStatics(customer.getLottos(), lottoWinning);

        // 당첨 통계
        OutputView.printConstantMessage(WINNING_STATICS);
        OutputView.printWinningStatics(winningEnquiry.getStatics());

        // 총 수익률 출력
        OutputView.printRateOfReturn(winningEnquiry.calculateRateOfReturn(customer.getMoney()));
    }

    private void payLottoAmount() {
        // 로또 구입 금액을 입력
        OutputView.printConstantMessage(PAY_MONEY);
        String pay = InputView.requestPayMoney();

        try {
            customer = new Customer(pay);
            OutputView.println(String.valueOf(customer.getMoney()));
        }
        catch (IllegalArgumentException error) {
            payLottoAmount();
        }
    }

    private void issueLotto() {
        // 로또 발행
        numOfLotto = customer.getMoney() / LOTTO_PRICE.getNumber();
        OutputView.printBuyLotto(BUY_LOTTO, numOfLotto);

        while (customer.getLottosSize() < numOfLotto) {
            customer.buyLotto();
        }
        OutputView.printLottos(customer);
    }

    private void inputBonusNumber() {
        // 보너스 번호 입력
        try {
            OutputView.printConstantMessage(BONUS_NUMBER);
            String _input = InputView.requestBonusNumber();

            lottoWinning.setBonusNumber(_input);
            OutputView.println(String.valueOf(lottoWinning.getBonusNumber()));
        } catch (IllegalArgumentException error) {
            inputBonusNumber();
        }
    }

    private void inputWinningNumber() {
        try {
            // 당첨 번호 입력
            OutputView.printConstantMessage(WINNING_NUMBER);
            String _winningNumber = InputView.requestWinningNumber();

            lottoWinning = new LottoWinning(_winningNumber);
            OutputView.printLottoWinning(lottoWinning.getWinningNumber());
        } catch (IllegalArgumentException error) {
            inputWinningNumber();
        }
    }
}
