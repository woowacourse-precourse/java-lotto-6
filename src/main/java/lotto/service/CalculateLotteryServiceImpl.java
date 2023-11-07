package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.MatchCounterDTO;
import lotto.dto.MoneyDTO;
import lotto.dto.WinningStatisticDTO;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.repository.LottoRepository;
import lotto.repository.WinningLottoRepository;

public class CalculateLotteryServiceImpl implements CalculateLotteryService {
    private static final Integer ONE = 1;
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer SIX = 6;

    private final LottoRepository lottoRepository;
    private final WinningLottoRepository winningLottoRepository;

    public CalculateLotteryServiceImpl(LottoRepository lottoRepository, WinningLottoRepository winningLottoRepository) {
        this.lottoRepository = lottoRepository;
        this.winningLottoRepository = winningLottoRepository;
    }

    @Override
    public WinningStatisticDTO countMatchesNumber() {
        Map<String, Integer> counter = initCounter();
        List<Lotto> entireLotto = getEntireLotto();
        WinningLotto winningLotto = getWinningLotto();

        for (Lotto lotto : entireLotto) {
            MatchCounterDTO matchCounterDTO = winningLotto.countMatchesWholeNumber(lotto);
            String key = mappingKeyByCount(matchCounterDTO);
            increaseCountByKey(counter, key);
        }

        return new WinningStatisticDTO(
                counter.get("three number matched"),
                counter.get("four number matched"),
                counter.get("five number matched"),
                counter.get("five number and bonus number matched"),
                counter.get("siz number matched")
        );
    }

    @Override
    public MoneyDTO calculateReturnRates(WinningStatisticDTO winningStatisticDTO) {
        return null;
    }

    private List<Lotto> getEntireLotto() {
        return lottoRepository.findAll();
    }

    private WinningLotto getWinningLotto() {
        return winningLottoRepository.find();
    }

    private Map<String, Integer> initCounter() {
        Map<String, Integer> counter = new HashMap<>();

        counter.put("three number matched", 0);
        counter.put("four number matched", 0);
        counter.put("five number matched", 0);
        counter.put("five number and bonus number matched", 0);
        counter.put("six number matched", 0);

        return counter;
    }

    private String mappingKeyByCount(MatchCounterDTO matchCounterDTO) {
        if (matchCounterDTO.getCountBonus().equals(ONE)) {
            return "five number and bonus number matched"; // 상수화 하기
        }
        if (matchCounterDTO.getCountLotto().equals(THREE)) {
            return "three number matched";
        }
        if (matchCounterDTO.getCountLotto().equals(FOUR)) {
            return "four number matched";
        }
        if (matchCounterDTO.getCountLotto().equals(FIVE)) {
            return "five number matched";
        }
        if (matchCounterDTO.getCountLotto().equals(SIX)) {
            return "six number matched";
        }

        throw new IllegalArgumentException(); // 에러문 추가
    }

    private void increaseCountByKey(Map<String, Integer> counter, String key) {
        counter.put(key, counter.get(key) + ONE);
    }
}
