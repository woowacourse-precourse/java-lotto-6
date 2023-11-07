package lotto.service;

import static lotto.util.Censor.validateUniqueBonusNumber;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.repository.MemoryTicketRepository;

public class BonusNumberService {

    private final MemoryTicketRepository memoryTicketRepository;

    public BonusNumberService(MemoryTicketRepository memoryTicketRepository) {
        this.memoryTicketRepository = memoryTicketRepository;
    }

    public BonusNumber announcementBonusNumber(String input) {
        BonusNumber bonus = new BonusNumber();
        Integer bonusNumber = Integer.parseInt(input);
        Lotto numbers = memoryTicketRepository.findNumbers().getLotto();

        validateUniqueBonusNumber(bonusNumber, numbers);
        bonus.setBonusNumber(bonusNumber);
        return memoryTicketRepository.announcementBonus(bonus);
    }

}
