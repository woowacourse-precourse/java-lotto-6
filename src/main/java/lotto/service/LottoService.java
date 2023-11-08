package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoNumber;
import lotto.enums.StatisticsInfo;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.enums.StatisticsInfo.RANK_2;
import static lotto.enums.StatisticsInfo.RANK_5;

public class LottoService {
    final ArrayList<Lotto> lottos;

    public LottoService() {
        this.lottos = new ArrayList<>();
    }

    public void createLottos(Integer lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            this.lottos.add(createLotto());
        }
    }

    private Lotto createLotto() {
        return new Lotto(createLottoNumber());
    }

    private List<Integer> createLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN.getNumber(),
                LottoNumber.MAX.getNumber(),
                LottoNumber.COUNT.getNumber()
        );

        return sortLottoNumber(lottoNumbers);
    }

    private List<Integer> sortLottoNumber(List<Integer> lottoNumber) {
        return lottoNumber.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public ArrayList<Lotto> getLottos() {
        return this.lottos;
    }

    public Integer getLottoCount() {
        return this.lottos.size();
    }

    public Integer getPurchaseAmount() {
        return this.lottos.size() * LottoNumber.PRICE.getNumber();
    }

    public ArrayList<Integer> getRankCount(List<Integer> winningNumbers, Integer bonusNumber) {
        ArrayList<Integer> rankCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        Map<Integer, List<Lotto>> lottoGroupByMatchCount = getLottoGroupByMatchCount(winningNumbers);

        lottoGroupByMatchCount.forEach((matchCount, lottos) -> {
            if (
                    matchCount == RANK_2.getMatchCount()
                            && lottos.stream().anyMatch(lotto -> lotto.isContainBonusNumber(bonusNumber))
            ) {
                rankCount.set(RANK_2.ordinal(), lottos.size());
                return;
            }
            rankCount.set(StatisticsInfo.getOrdinalByMatchCount(matchCount), lottos.size());
        });

        return rankCount;
    }

    private Map<Integer, List<Lotto>> getLottoGroupByMatchCount(List<Integer> winningNumbers) {
        return this.lottos.stream()
                .collect(Collectors.groupingBy(lotto -> lotto.getMatchCount(winningNumbers)))
                .entrySet().stream()
                .filter(entry -> entry.getKey() >= RANK_5.getMatchCount())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
