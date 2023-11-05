package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.StateType;
import lotto.dto.LottoDto;
import lotto.model.domain.Game;
import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.repository.LottoRepository;

public class LottoService {
    private final LottoRepository lottoRepository;

    private static final int LOTTO_PRICE = 1000;

    public LottoService() {
        this.lottoRepository = new LottoRepository();
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
        List<Lotto> lottoTickets = lottos.getAllLotto();
        Game lottoGame = lottoRepository.findGame();

        lottoTickets.forEach(lotto -> lotto.setStateType(compareWinningNumbers(lotto.getNumbers(), lottoGame)));

    }

    private StateType compareWinningNumbers(List<Integer> numbers, Game lottoGame) {
        List<Integer> winningNumbers = lottoGame.getWinningNumbers();
        int bonusNumber = lottoGame.getBonusNumber();
        int correctCount = 0;
        boolean correctBonus = false;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                correctCount++;
            }

            if (number == bonusNumber) {
                correctBonus = true;
            }
        }

        return StateType.valueOf(correctCount, correctBonus);
    }
}
