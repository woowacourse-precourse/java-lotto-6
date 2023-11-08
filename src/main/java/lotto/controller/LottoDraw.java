package lotto.controller;

import lotto.model.Customer;
import lotto.model.LottoWinning;
import lotto.model.WinningEnquiry;
import lotto.validation.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

import java.util.List;

import static java.lang.Integer.parseInt;
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
            if (validationLottoRange(customer.getLastLotto().getNumbers())) {
                customer.throwLastLotto();
            }
        }
        OutputView.printLottos(customer);
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
        if (LottoValidator.checkIsNotNumber(_input)) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER.getMessage());
            return true;
        }

        // check 1 ~ 45
        if (!LottoValidator.checkRangeNumber(parseInt(_input), RANGE_START.getNumber(), RANGE_END.getNumber())) {
            OutputView.printError(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            return true;
        }

        // check winning lotto duplicate
        if (LottoValidator.checkDuplicateNumber(lottoWinning.getWinningNumber(), parseInt(_input))) {
            OutputView.printError(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            return true;
        }

        return false;
    }

    private boolean validationWinningLotto(String _input) {
        if (LottoValidator.checkSizeIsSix(_input)) {
            OutputView.printError(ErrorMessage.SIZE_IS_NOT_SIX.getMessage());
            return true;
        }

        List<String> _lotto = List.of(_input.split(","));
        if (LottoValidator.checkIsNotNumberList(_lotto)) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER_LIST.getMessage());
            return true;
        }

        List<Integer> __lotto = _lotto.stream().map(Integer::parseInt).toList();
        if (LottoValidator.checkRangeLotto(__lotto)) {
            OutputView.printError(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            return true;
        }

        return false;
    }

    private boolean validationLottoRange(List<Integer> _lotto) {
        if (LottoValidator.checkRangeLotto(_lotto)) {
            OutputView.printError(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            return true;
        }
        return false;
    }

}
