package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.repository.LottoRepository;
import lotto.repository.WinningRepository;

import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final WinningRepository winningRepository;
    private final Validation validation;

    public LottoService(LottoRepository lottoRepository, WinningRepository winningRepository, Validation validation) {
        this.lottoRepository = lottoRepository;
        this.winningRepository = winningRepository;
        this.validation = validation;
    }

    public void issueLotto(String price) throws IllegalArgumentException {
        Integer number = validation.validatePriceAndReturnNumber(price);
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoRepository.save(new Lotto(numbers));
        }
    }

    public List<Lotto> findAllLotto() {
        return lottoRepository.findAll();
    }

    public void issueWinning(String winningNumber, String bonusNumber) throws IllegalArgumentException {
        List<Integer> validatedWinning = validation.validateWinning(winningNumber);
        Integer validatedBonus = validation.validateBonus(bonusNumber, validatedWinning);
        Winning winning = new Winning(validatedWinning, validatedBonus);
        winningRepository.save(winning);

        System.out.println("validatedWinning = " + validatedWinning);
        System.out.println("validatedBonus = " + validatedBonus);
    }






}
