package lotto.model.service;

import static lotto.constant.StateType.STATES;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import lotto.constant.StateType;
import lotto.dto.LottoDto;
import lotto.model.domain.Game;
import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.repository.LottoRepository;

public class LottoService {
    private static final HashMap<StateType, Integer> PRIZE_BY_STATE = new HashMap<>();
    private final LottoRepository lottoRepository;
    
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_PRIZE_STATE = 0;
    private static final int MAX_PRIZE_STATE = 4;


    static {
        PRIZE_BY_STATE.put(StateType.THREE_MATCH, 5000);
        PRIZE_BY_STATE.put(StateType.FOUR_MATCH, 50000);
        PRIZE_BY_STATE.put(StateType.FIVE_MATCH_NO_BONUS, 1500000);
        PRIZE_BY_STATE.put(StateType.FIVE_MATCH_BONUS, 30000000);
        PRIZE_BY_STATE.put(StateType.SIX_MATCH, 2000000000);
    }

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void createLottos(LottoDto lottoDto) {
        int lottoCount = getLottoCount(lottoDto.getLottoPurchaseAmount());

        while (lottoCount > 0) {
            lottoRepository.saveLottos(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoCount--;
        }
    }

    private static int getLottoCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE;
    }

    public Lottos getLottos() {
        return lottoRepository.findLottos();
    }

    public void createGame(LottoDto lottoDto) {
        lottoRepository.saveGame(lottoDto.getWinningNumbers(), lottoDto.getBonusNumber());
    }

    public void compareLottosWithWinningNumbers() {
        Lottos lottos = lottoRepository.findLottos();
        Game lottoGame = lottoRepository.findGame();

        lottos.getAllLotto().forEach(lotto ->
                lottos.increaseStateCount(compareWinningNumbers(lotto, lottoGame)));
    }

    private StateType compareWinningNumbers(Lotto lotto, Game lottoGame) {
        List<Integer> winningNumbers = lottoGame.getWinningNumbers();
        int bonusNumber = lottoGame.getBonusNumber();
        int correctCount = 0;
        boolean correctBonus = false;

        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                correctCount++;
            }

            if (number == bonusNumber) {
                correctBonus = true;
            }
        }

        return StateType.valueOf(correctCount, correctBonus);
    }

    public HashMap<StateType,Integer> getResult() {
        return lottoRepository.findLottos().getAllResult();
    }

    public double getProfitRate() {
        HashMap<StateType, Integer> resultOfLottoGame = lottoRepository.findLottos().getAllResult();
        double profit = 0f;
        double totalLottosCount = (float) lottoRepository.findLottos()
                .getAllLotto()
                .size();

        for(int i=MIN_PRIZE_STATE ; i<=MAX_PRIZE_STATE ; i++) {
            profit += resultOfLottoGame.getOrDefault(STATES[i],0) * PRIZE_BY_STATE.get(STATES[i]);
        }

        return (profit / (totalLottosCount * 1000)) * 100;
    }
}
