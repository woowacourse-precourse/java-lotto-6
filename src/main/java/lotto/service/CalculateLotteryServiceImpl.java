package lotto.service;

import java.util.List;
import lotto.dto.MatchCounterDTO;
import lotto.dto.MoneyDTO;
import lotto.dto.WinningStatisticDTO;
import lotto.enums.Constant;
import lotto.model.Lotto;
import lotto.model.MatchCounter;
import lotto.model.WinningLotto;
import lotto.repository.LottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.utils.Converter;

public class CalculateLotteryServiceImpl implements CalculateLotteryService {
    private static final Long ZERO = 0L;
    private static final Long returnsOfThreeMatched = 5000L;
    private static final Long returnsOfFourMatched = 50000L;
    private static final Long returnsOfFiveMatched = 1500000L;
    private static final Long returnsOfFiveAndBonusMatched = 30000000L;
    private static final Long returnsOfSixMatched = 2000000000L;

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
        Long earn = getEarn(winningStatisticDTO);

        Float returnRates = Converter.longToFloat(earn) / Converter.integerToFloat(moneyDTO.getAmount()) * Constant.NUMBER_USED_TO_MAKE_PERCENTAGE.getContentToFloat();
        Long offsetNumber = Constant.NUMBER_USED_TO_ROUND_FIRST_DIGIT.getContentToLong();
        returnRates = Math.round(returnRates * offsetNumber) / Converter.longToFloat(offsetNumber);

        return new MoneyDTO(moneyDTO.getAmount(), returnRates);
    }

    private Long getEarn(WinningStatisticDTO winningStatisticDTO) {
        Long earn = ZERO;
        earn += returnsOfThreeMatched * winningStatisticDTO.getMatchedThree();
        earn += returnsOfFourMatched * winningStatisticDTO.getMatchedFour();
        earn += returnsOfFiveMatched * winningStatisticDTO.getMatchedFive();
        earn += returnsOfFiveAndBonusMatched * winningStatisticDTO.getMatchedFiveAndBonus();
        earn += returnsOfSixMatched * winningStatisticDTO.getMatchedSix();

        return earn;
    }

    private List<Lotto> getEntireLotto() {
        return lottoRepository.findAll();
    }

    private WinningLotto getWinningLotto() {
        return winningLottoRepository.find();
    }
}
