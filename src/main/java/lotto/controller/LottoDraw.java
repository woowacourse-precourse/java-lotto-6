package lotto.controller;

import lotto.model.Customer;
import lotto.model.LottoWinning;
import lotto.validation.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

import java.util.List;

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
        payLottoAmount();

        // 로또 발행
        if (issueLotto()) return;

        // 당첨 번호 입력
        inputWinningNumber();

        // 보너스 번호 입력
        inputBonusNumber();

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

    private void payLottoAmount() {
        // 로또 구입 금액을 입력
        OutputView.printConstantMessage(PAY_MONEY);
        String pay = InputView.requestPayMoney();

        try {
            if (validationPayAmount(pay)) {
                throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage()+ErrorMessage.INPUT.getMessage());
            }
            customer = new Customer(parseInt(pay));
            OutputView.println(String.valueOf(customer.getMoney()));
        }
        catch (IllegalArgumentException error) {
            payLottoAmount();
        }
    }

    private boolean validationPayAmount(String pay) {
        if (Validator.checkIsNotNumber(pay)) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER.getMessage());
            return true;
        }

        if (Validator.checkIsPositive(parseInt(pay))) {
            OutputView.printError(ErrorMessage.PAY_IS_NOT_POSITIVE.getMessage());
            return true;
        }

        if (Validator.checkMultipleOf1000(parseInt(pay))) {
            OutputView.printError(ErrorMessage.PAY_NOT_MULTIPLE_OF_1000.getMessage());
        }
        return false;
    }

    private boolean issueLotto() {
        boolean flag = false;
        // 로또 발행
        numOfLotto = customer.getMoney() / LOTTO_PRICE.getLottoConstant();
        OutputView.printBuyLotto(BUY_LOTTO, numOfLotto);
        for(int i = 0; i < numOfLotto ; i++) {
            customer.buyLotto();
            // TODO: 로또 잘못 발행되면 재발행하는 로직으로 수정
            if (validationLottoRange(customer.getLastLotto().getNumbers())) {
                flag = true;
                break;
            }
        }
        OutputView.printLottos(customer);
        return flag;
    }

    private void inputBonusNumber() {
        // 보너스 번호 입력
        try {
            OutputView.printConstantMessage(BONUS_NUMBER);
            String _input = InputView.requestBonusNumber();
            if (validationBonusNumber(_input)) {
                throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INPUT.getMessage());
            }

            lottoWinning.initBonusNumber(_input);
            OutputView.println(String.valueOf(lottoWinning.getBonusNumber()));
        } catch (IllegalArgumentException error) {

        }
    }

    private void inputWinningNumber() {
        try {
            // 당첨 번호 입력
            OutputView.printConstantMessage(WINNING_NUMBER);
            String _winningNumber = InputView.requestWinningNumber();

            if (validationWinningLotto(_winningNumber)) {
                throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INPUT.getMessage());
            }

            lottoWinning = new LottoWinning(_winningNumber);
            OutputView.printLottoWinning(lottoWinning.getWinningNumber());
        } catch (IllegalArgumentException error) {
            inputWinningNumber();
        }
    }

    private boolean validationBonusNumber(String _input) {
        // check Number
        if (Validator.checkIsNotNumber(_input)) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER.getMessage());
            return true;
        }

        // check 1 ~ 45
        if (!Validator.checkRangeNumber(parseInt(_input), 1, 45)) {
            OutputView.printError(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            return true;
        }

        // check winning lotto duplicate
        if (Validator.checkDuplicateNumber(lottoWinning.getWinningNumber(), parseInt(_input))) {
            OutputView.printError(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            return true;
        }

        return false;
    }


    private boolean validationWinningLotto(String _input) {
        if (Validator.checkSizeIsSix(_input)) {
            OutputView.printError(ErrorMessage.SIZE_IS_NOT_SIX.getMessage());
            return true;
        }

        List<String> _lotto = List.of(_input.split(","));
        if (Validator.checkIsNotNumberList(_lotto)) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER_LIST.getMessage());
            return true;
        }

        List<Integer> __lotto = _lotto.stream().map(Integer::parseInt).toList();
        if (Validator.checkRangeLotto(__lotto)) {
            OutputView.printError(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            return true;
        }

        return false;
    }

    private boolean validationLottoRange(List<Integer> _lotto) {
        if (Validator.checkRangeLotto(_lotto)) {
            OutputView.printError(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            return true;
        }
        return false;
    }

}
