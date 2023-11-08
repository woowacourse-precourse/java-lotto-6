package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoConstraint;
import lotto.domain.LottoRepository;
import lotto.domain.WinningNumber;
import lotto.dto.Money;
import lotto.util.RandomLottoNumGenerator;
import lotto.util.Validation;

public class LottoService {
    private final LottoRepository lottoRepository = new LottoRepository();
//    private final WinningNumber winningNumber;

    public void buyLotto(Money money){
        int tickets;
        tickets = Validation.validateDivide(Validation.validateInt(money.getMoney()), LottoConstraint.MIN_PRICE);
        for (int ticket=0; ticket < tickets;ticket++){
            lottoRepository.addOne(new Lotto(RandomLottoNumGenerator.generateLotto()));
        }
    }
}
