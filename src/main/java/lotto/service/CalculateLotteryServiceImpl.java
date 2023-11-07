package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.MatchCounterDTO;
import lotto.dto.MoneyDTO;
import lotto.dto.WinningStatisticDTO;
import lotto.enums.Constant;
import lotto.model.Lotto;
import lotto.model.MatchCounter;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.repository.LottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.utils.Converter;

public class CalculateLotteryServiceImpl implements CalculateLotteryService {
    private static final Integer ZERO = 0;

    private final LottoRepository lottoRepository;
    private final WinningLottoRepository winningLottoRepository;

    public CalculateLotteryServiceImpl(LottoRepository lottoRepository, WinningLottoRepository winningLottoRepository) {
        this.lottoRepository = lottoRepository;
        this.winningLottoRepository = winningLottoRepository;
    }

    @Override
    public WinningStatisticDTO countMatchesNumber() {
        MatchCounter matchCounter = new MatchCounter();
        List<Lotto> entireLotto = getEntireLotto();
        WinningLotto winningLotto = getWinningLotto();

        for (Lotto lotto : entireLotto) {
            MatchCounterDTO matchCounterDTO = winningLotto.countMatchesWholeNumber(lotto);
            String key = matchCounter.matchingKeyByCount(
                    matchCounterDTO.getCountLotto(),
                    matchCounterDTO.getCountBonus()
            );
            matchCounter.increaseCountByKey(key);
        }

        return matchCounter.createWinningStatisticDTO();
    }

    @Override
    public MoneyDTO calculateReturnRates(MoneyDTO moneyDTO, WinningStatisticDTO winningStatisticDTO) {
        Integer earn = getEarn(winningStatisticDTO);

        Float returnRates = Converter.integerToFloat(earn) / Converter.integerToFloat(moneyDTO.getAmount()) * Constant.NUMBER_USED_TO_MAKE_PERCENTAGE.getContentToFloat();
        Integer offsetNumber = Constant.NUMBER_USED_TO_ROUND_FIRST_DIGIT.getContentToInteger();
        returnRates = Math.round(returnRates * offsetNumber) / Converter.integerToFloat(offsetNumber);

        return new MoneyDTO(moneyDTO.getAmount(), returnRates);
    }

    private Integer getEarn(WinningStatisticDTO winningStatisticDTO) {
        Integer earn = ZERO;
        earn += 5000 * winningStatisticDTO.getMatched3(); // 숫자 상수화 하기
        earn += 50000 * winningStatisticDTO.getMatched4();
        earn += 1500000 * winningStatisticDTO.getMatched5();
        earn += 30000000 * winningStatisticDTO.getMatched5AndBonusNumber();
        earn += 2000000000 * winningStatisticDTO.getMatched5AndBonusNumber(); // Long으로 바꾸기

        return earn;
    }

    private List<Lotto> getEntireLotto() {
        return lottoRepository.findAll();
    }

    private WinningLotto getWinningLotto() {
        return winningLottoRepository.find();
    }
}
