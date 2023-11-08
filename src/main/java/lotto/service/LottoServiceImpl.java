package lotto.service;

import static lotto.enums.ViewMessageType.INPUT_SEPARATOR;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.enums.WinningRankType;
import lotto.utils.LottoNumbersValidator;
import lotto.utils.PaymentValidator;
import lotto.utils.RandomNumberGenerator;

public class LottoServiceImpl implements LottoService {
    private static LottoService instance = new LottoServiceImpl();
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private LottoServiceImpl() {}

    public static LottoService getInstance() {
        return instance;
    }

    @Override
    public Lottos buyLottos(String paymentInput) throws NumberFormatException {
        PaymentValidator.validateInteger(paymentInput);
        int payment = Integer.parseInt(paymentInput);

        Lottos lottos = new Lottos(payment);

        int buyCount = payment / LOTTO_PRICE;
        for (int cnt=0; cnt < buyCount; cnt++) {
            lottos.addLotto(issueAutoLotto());
        }
        return lottos;
    }

    public Lotto issueAutoLotto() {
        return new Lotto(
                RandomNumberGenerator.makeUniQueRandomNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE)
                        .stream()
                        .sorted()
                        .toList()
        );
    }

    @Override
    public Lotto drawWinningNumbers(String numbersInput) {
        LottoNumbersValidator.validateSeparator(numbersInput);
        return new Lotto(
                Arrays.stream(numbersInput.split(INPUT_SEPARATOR.getMessage()))
                        .map(Integer::parseInt)
                        .toList()
        );
    }

    @Override
    public int drawBonusNumber(String number) {
        LottoNumbersValidator.validateInteger(number);
        return Integer.parseInt(number);
    }

    @Override
    public WinningResult calculateWinning(Lottos lottos, WinningLotto winningLotto) {
        Map<WinningRankType, Integer> rankingCounts = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            WinningRankType rankType = matchRankType(lotto, winningLotto);
            rankingCounts.put(
                    rankType,
                    rankingCounts.getOrDefault(rankType, 0) + 1
            );
        }
        return new WinningResult(rankingCounts);
    }

    @Override
    public WinningRankType matchRankType(Lotto lotto, WinningLotto winningLotto) {
        int winningCount = 0;
        int bonusCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningLotto.isInWinningNumber(number)) {
                winningCount++;
            }
            else if (winningLotto.isSameBonusNumber(number)) {
                bonusCount++;
            }
        }
        return WinningRankType.selectRankingType(winningCount, bonusCount);
    }

    @Override
    public double calculateRateOfReturn(WinningResult winningResult, int payment) {
        double totalPrize = 0L;
        for (WinningRankType rankType : winningResult.getResult().keySet()) {
            int count = winningResult.getResult().get(rankType);
            totalPrize += rankType.calculateWinnings(count);
        }
        return (totalPrize / payment) * 100;
    }
}
