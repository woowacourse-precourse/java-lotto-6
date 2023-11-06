package lotto.service;

import lotto.model.*;
import lotto.service.view.InputViewService;
import lotto.service.view.OutputViewService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @Class : 로또 서비스 클래스
 */
public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_STAT_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;


    public void start() {
        int amount = getAmount();

        List<Lotto> purchasedLottoList = issueLottoTicket(amount);

        Lotto winnigNumbers = getWinnigNumbers();
        int bonusNumber = getBonusNumber(winnigNumbers.getNumbers());

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winnigNumbers, bonusNumber);

        printResult(purchasedLottoList, lottoResultCalculator, amount);
    }

    private int getAmount() {
        OutputViewService.outputAmount();
        try {
            return InputViewService.inputAmount(LOTTO_PRICE);
        } catch (IllegalArgumentException e) {
            OutputViewService.outPutErrorMessage(e);
            return getAmount();
        }
    }

    private List<Lotto> issueLottoTicket(int amount) {
        LottoMachine lottoMachine = new LottoMachine(LOTTO_STAT_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
        List<Lotto> lottoList = lottoMachine.getLottoList(LOTTO_PRICE, amount);
        OutputViewService.outputEa(lottoList.size());
        OutputViewService.outputLottoList(lottoList);
        return lottoList;
    }

    private Lotto getWinnigNumbers() {
        OutputViewService.outputWinnigNumbers();
        try {
            return InputViewService.inputWinnigNumbers(LOTTO_STAT_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
        } catch (IllegalArgumentException e) {
            OutputViewService.outPutErrorMessage(e);
            return getWinnigNumbers();
        }
    }

    private int getBonusNumber(List<Integer> numbers) {
        OutputViewService.outputBonusNumber();
        try {
            return InputViewService.inputBonusNumber(numbers, LOTTO_STAT_NUMBER, LOTTO_END_NUMBER);
        } catch (IllegalArgumentException e) {
            OutputViewService.outPutErrorMessage(e);
            return getBonusNumber(numbers);
        }
    }

    private void printResult(List<Lotto> purchasedLottoList, LottoResultCalculator lottoCalculator, int amount) {
        OutputViewService.outputStatisticIntro();
        List<LottoResult> lottoResultList = lottoCalculator.getLottoResults(purchasedLottoList);
        OutputViewService.outputStatistics(lottoResultList);
        OutputViewService.outputRateOfReturn(getRateOfReturn(amount, lottoResultList));
    }

    private static double getRateOfReturn(int amount, List<LottoResult> lottoResultList) {
        if (amount == 0) {
            throw new IllegalArgumentException("Amount cannot be zero.");
        }
        int totalReward = lottoResultList.stream().mapToInt(LottoResult::getTotalReward).sum();
        BigDecimal rate = BigDecimal.valueOf(((double) totalReward / amount)).multiply(BigDecimal.valueOf(100));

        BigDecimal rounded = rate.setScale(2, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }
}
