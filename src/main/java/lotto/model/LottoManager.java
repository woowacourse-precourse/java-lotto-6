package lotto.model;

import java.util.List;

import lotto.util.validation.WinningLottoValidator;

public class LottoManager {
    public static final int AMOUNT_UNIT = 1000;
    private final LottoMachine lottoMachine;

    public LottoManager(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> createLottoTickets(final int amount) {
        final int purchaseQuantity = amount / AMOUNT_UNIT;
        return lottoMachine.createLotto(purchaseQuantity);
    }

    public Lotto createWinningLottoTicket(final List<Integer> numbers) {
        return lottoMachine.createWinningLotto(numbers);
    }

    public int createBonusNumber(final Lotto winningLottoTicket, final int bonusNumber) {
        final WinningLottoValidator validator = new WinningLottoValidator(bonusNumber);
        validator.validate(winningLottoTicket);
        return bonusNumber;
    }
}
