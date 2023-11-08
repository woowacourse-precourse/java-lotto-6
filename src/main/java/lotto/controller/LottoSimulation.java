package lotto.controller;

import lotto.Lotto;
import lotto.domain.Amount;
import lotto.domain.Checker;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.constant.LottoConstant.*;
import static lotto.constant.LottoErrorMessage.*;

public class LottoSimulation {
    private final LottoOutputView outputView = new LottoOutputView();
    private final LottoInputView inputView = new LottoInputView(outputView);

    public void execute() {
        Amount amount = readPurchaseAmount();
        int count = amount.getCount();
        List<Lotto> lottos = makeLottoList(count);
        outputView.printLottoNumbers(count, lottos);
        WinningNumber winningNumber = readWinningNumber();
        readBonusNumber(winningNumber);
        Result result = new Result(makeCheckerList(lottos, winningNumber));
        outputView.printWinningStatistics(result);
        outputView.printEarningRate(result.getEarningRate(amount.getAmount()));
    }

    private Amount readPurchaseAmount() {
        while (true) {
            try {
                return new Amount(Integer.parseInt(inputView.readPurchaseAmount()));
            } catch (IllegalArgumentException e) {
                outputView.printMessage(String.format(PURCHASE_AMOUNT_ERROR_MESSAGE.getErrorMessage(), ERROR_MESSAGE.getString()));
            }
        }
    }

    private List<Lotto> makeLottoList(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO.getConstant(); i < count; i++) {
            lottos.add(Lotto.make());
        }
        return lottos;
    }

    private WinningNumber readWinningNumber() {
        while (true) {
            try {
                return new WinningNumber(stringToNumberList(inputView.readWinningNumber()));
            } catch (IllegalArgumentException e) {
                outputView.printMessage(checkErrorMessage(e));
            }
        }
    }

    private void readBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                winningNumber.setBonusNumber(Integer.parseInt(inputView.readBonusNumber()));
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(String.format(LOTTO_NUMBER_ERROR_MESSAGE.getErrorMessage(), ERROR_MESSAGE.getString()));
            }
        }
    }

    private List<Checker> makeCheckerList(List<Lotto> lottos, WinningNumber winningNumber) {
        List<Checker> checkers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            checkers.add(new Checker(lotto, winningNumber));
        }
        return checkers;
    }

    private List<Integer> stringToNumberList(String input) {
        return Arrays.stream(input.split(LOTTO_NUMBER_SEPARATER.getString()))
                .map(Integer::parseInt)
                .toList();
    }

    private String checkErrorMessage(IllegalArgumentException e) {
        if (e.getMessage().equals(LOTTO_LENGTH_ERROR_MESSAGE.getErrorMessage())) {
            return String.format(LOTTO_LENGTH_ERROR_MESSAGE.getErrorMessage(), ERROR_MESSAGE.getString());
        }
        if (e.getMessage().equals(LOTTO_NUMBER_ERROR_MESSAGE.getErrorMessage())) {
            return String.format(LOTTO_NUMBER_ERROR_MESSAGE.getErrorMessage(), ERROR_MESSAGE.getString());
        }
        return String.format(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE.getErrorMessage(), ERROR_MESSAGE.getString());
    }
}
