package lotto.controller;

import static lotto.utils.CalculationUtils.isDivisible;
import static lotto.utils.StringUtils.parseInt;
import static lotto.view.ErrorMessage.*;
import static lotto.view.InputMessage.ENTER_BONUS_NUMBER;
import static lotto.view.InputMessage.HOW_MUCH_MONEY_FOR_LOTTO_PURCHASE;
import static lotto.view.InputView.readInput;
import static lotto.view.OutputView.*;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static final int ONE_LOTTO_PRICE = 1000;
    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = new LottoService();
    }

    public int receiveMoney() {
        String userInput = readInput(HOW_MUCH_MONEY_FOR_LOTTO_PURCHASE.getInputMessage());
        validateReceivedMoney(userInput);
        return parseInt(userInput);
    }


    public int registerBonusNumber() {
        String userInput = readInput(ENTER_BONUS_NUMBER.getInputMessage());
        return parseInt(userInput);
    }




    public List<Lotto> generateLottoList(int count) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result.add(lottoService.generateLotto());
        }

        return result;
    }

    public void showPurchaseResult(List<Lotto> lottoList, int totalPurchaseAmount) {
        int purchaseCount = totalPurchaseAmount / ONE_LOTTO_PRICE;
        String purchaseResult = lottoService.makePurchaseResultOutputStatement(lottoList, purchaseCount);
        printResult(purchaseResult);
    }

    public void showStatisticsResult(List<Lotto> lottoList, Lotto answer, int bonusNumber) {
        String result = lottoService.makeWinningResultOutputStatement(lottoList, answer, bonusNumber);
        printResult(result);
    }




    private void validateReceivedMoney(String userInput) {
        // 숫자 인지 검증
        int number = parseInt(userInput);

        if (!isDivisible(number, ONE_LOTTO_PRICE)) {
            throw new IllegalArgumentException(RECEIVED_MONEY_NOT_MULTIPLE_OF_1000.getErrorMessage());
        }
    }







}