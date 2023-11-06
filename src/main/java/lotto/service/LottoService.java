package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;
import lotto.domain.LottoWinning;
import lotto.dto.LottoStatistics;
import lotto.repository.LottoRepository;
import lotto.repository.LottoWinningRepository;
import lotto.util.LottoGenerator;

public class LottoService {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoRepository lottoRepository = new LottoRepository();
    private final LottoWinningRepository lottoWinningRepository = new LottoWinningRepository();

    public void buyLotto(int purchaseAmount){
        int lottoCount = purchaseAmount / LottoConfig.LOTTO_BUYING_UNIT.getValue();

        List<Lotto> lottos = Stream
                .generate(lottoGenerator::generate)
                .limit(lottoCount)
                .sorted()
                .toList();

        lottoRepository.save(lottos);
    }

    public void saveWinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        LottoWinning lottoWinning = new LottoWinning(new Lotto(winningNumbers), bonusNumber);

        lottoWinningRepository.save(lottoWinning);
    }

    public LottoStatistics calcLotto(List<Lotto> myLotto, LottoWinning lottoWinning){
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        int fourthCount = 0;
        int fifthCount = 0;

        for(Lotto lotto : myLotto){
            int sameCount = getSameCount(lotto, lottoWinning);
            boolean isContainsBonusNumber = isContainsBonusNumber(lotto, lottoWinning);

            if(sameCount == 6){
                firstCount++;
            } else if(sameCount == 5 && isContainsBonusNumber){
                secondCount++;
            } else if(sameCount == 5){
                thirdCount++;
            } else if(sameCount == 4){
                fourthCount++;
            } else if(sameCount == 3){
                fifthCount++;
            }
        }

        int winningAmount = firstCount * LottoConfig.LOTTO_FIRST_PRIZE.getValue()
                + secondCount * LottoConfig.LOTTO_SECOND_PRIZE.getValue()
                + thirdCount * LottoConfig.LOTTO_THIRD_PRIZE.getValue()
                + fourthCount * LottoConfig.LOTTO_FOURTH_PRIZE.getValue()
                + fifthCount * LottoConfig.LOTTO_FIFTH_PRIZE.getValue();

        double returnRate = getReturnRate(winningAmount, LottoConfig.LOTTO_BUYING_UNIT.getValue() * myLotto.size());

        LottoStatistics lottoStatistics = new LottoStatistics(firstCount, secondCount, thirdCount, fourthCount, fifthCount, returnRate);

        return lottoStatistics;
    }

    private double getReturnRate(int winningAmount, int originalAmount){
        return winningAmount / originalAmount;
    }

    private int getSameCount(Lotto lotto, LottoWinning lottoWinning){
        Set<Integer> set = new HashSet<>();

        set.addAll(lotto.numbers());
        set.addAll(lottoWinning.getNumbers());

        return LottoConfig.LOTTO_NUMBER_COUNT.getValue() * 2 - set.size();
    }

    private boolean isContainsBonusNumber(Lotto lotto, LottoWinning lottoWinning){
        return lotto.numbers().contains(lottoWinning.getBonusNumber());
    }
}
