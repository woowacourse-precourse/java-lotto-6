package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.util.Parser;

public class LottoService implements LottoConstants {
    private LottoRepository lottoRepository;

    public LottoService() {
        lottoRepository = new LottoRepository();
    }

    public String createPurchaseAmount(String amountInput) {
        return lottoRepository.updatePurchaseAmount(amountInput);
    }

    public String createLotteries() {
        int totalQuantity = lottoRepository.getPurchaseQuantity();
        for (int quantity = 0; quantity < totalQuantity; quantity++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
            Lotto lotto = new Lotto(numbers);
            lottoRepository.insertLotto(lotto);
        }
        return lottoRepository.getLotteriesInfo();
    }

    public void createWinningNumbers(String numbersInput) {
        List<Integer> numbers = Parser.parseNumbers(numbersInput);
        lottoRepository.updateWinningNumbers(numbers);
    }

    public void createBonusNumber(String bonusInput) {
        int bonus = Parser.parseSingleNumber(bonusInput);
        lottoRepository.updateBonusNumber(bonus);
    }

    public String createLottoResult() {
        String lottoResult = lottoRepository.getLottoResult();
        return lottoResult;
    }
}
