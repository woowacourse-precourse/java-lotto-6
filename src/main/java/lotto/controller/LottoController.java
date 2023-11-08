package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoCollector;
import lotto.service.LottoPublishService;
import lotto.service.WinningService;
import lotto.utils.ExceptionMessage;

public class LottoController {

    private final LottoPublishService lottoPublishService;
    private final WinningService winningService;

    public LottoController(LottoPublishService lottoPublishService, WinningService winningService) {
        this.lottoPublishService = lottoPublishService;
        this.winningService = winningService;
    }

    public LottoCollector publishLotto(String inputPurchaseAmount) throws IllegalArgumentException {
        int purchaseAmount = validateType(inputPurchaseAmount);

        return lottoPublishService.publish(purchaseAmount);
    }

    private int validateType(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
        }
    }

    public void createWinningNumber(String winningNumber) {
        winningService.createWinningLotto(separateWinningNumber(winningNumber));
    }

    private List<Integer> separateWinningNumber(String winningNumber) {
        String[] separatedWinningNumbers = winningNumber.split(",");

        return new ArrayList<>(Arrays.stream(separatedWinningNumbers)
                .map(this::validateType)
                .toList());
    }
}
