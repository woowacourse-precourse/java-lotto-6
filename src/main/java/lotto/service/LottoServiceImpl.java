package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.WinningNumber;
import lotto.dto.WinningStatisticsDto;
import lotto.exception.NotValidGivenPriceException;

public class LottoServiceImpl implements LottoService {

    public LottoNumberGenerator lottoNumberGenerator;

    private static final int NUMBER_OF_LOTTO_DIGITS = 6;
    private static final int START_LOTTO_NUMBER_RANGE = 1;
    private static final int END_LOTTO_NUMBER_RANGE = 45;
    private static final int BONUS_LOTTO_NUMBER = 5;
    private static final int BONUS_LOTTO_KEY = 7;
    private static final int LOTTO_DEFAULT_PRICE = 1000;

    public LottoServiceImpl(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    @Override
    public List<Lotto> issueNewLotto(int price) {
        int issueCount = getNumberOfLottoToBeIssued(price);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator
                    .getRandomNumber(START_LOTTO_NUMBER_RANGE, END_LOTTO_NUMBER_RANGE,
                            NUMBER_OF_LOTTO_DIGITS)));
        }
        return lottos;
    }

    @Override
    public WinningStatisticsDto getWinningStatistics(List<Lotto> lottos, Lotto winningLotto,
                                                     int bonusNumber) {
        Map<Integer, Integer> countMap = countMatchNumber(lottos, winningLotto, bonusNumber);
        double winningRate = getWinningRate(countMap, lottos.size());
        return mapToWinningStatisticsDto(countMap, winningRate);
    }

    private WinningStatisticsDto mapToWinningStatisticsDto(Map<Integer, Integer> countMap, double winningRate) {
        return new WinningStatisticsDto(countMap.getOrDefault(3, 0), countMap.getOrDefault(4, 0),
                countMap.getOrDefault(5, 0), countMap.getOrDefault(7, 0),
                countMap.getOrDefault(6, 0), winningRate);
    }

    private double getWinningRate(Map<Integer, Integer> countMap, int totalPurchasedLottoCount) {
        double winningPrice = getWinningPrice(countMap);
        return (winningPrice * 100) / (totalPurchasedLottoCount * LOTTO_DEFAULT_PRICE);
    }

    private double getWinningPrice(Map<Integer, Integer> countMap) {
        double winningPrice = 0;
        for (int i = START_LOTTO_NUMBER_RANGE; i < END_LOTTO_NUMBER_RANGE; i++) {
            if (countMap.containsKey(i)) {
                winningPrice += WinningNumber.valueOf(i).getWinningAmount();
            }
        }
        return winningPrice;
    }

    private Map<Integer, Integer> countMatchNumber(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchNumber = countMatch(lotto, winningLotto);
            if (matchNumber == BONUS_LOTTO_NUMBER) {
                matchNumber = checkBonusAndChangeMatchNumber(lotto, bonusNumber);
            }
            countMap.put(matchNumber, countMap.getOrDefault(matchNumber, 1));
        }

        return countMap;
    }

    private int checkBonusAndChangeMatchNumber(Lotto lotto, int bonusNumber) {
        if (lotto.containNumber(bonusNumber)) {
            return BONUS_LOTTO_KEY;
        }
        return BONUS_LOTTO_NUMBER;
    }

    private int countMatch(Lotto lotto, Lotto winningLotto) {
        return (int) winningLotto.getNumbers().stream().
                filter(lotto::containNumber).
                count();
    }

    private int getNumberOfLottoToBeIssued(int price) throws IllegalArgumentException {
        if (price == 0 || price % 1000 != 0) {
            throw new NotValidGivenPriceException();
        }
        return price / 1000;
    }

}
