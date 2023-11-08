package lotto.service;

import lotto.domain.BonusNumber;
import lotto.repository.MemoryTicketRepository;

public class BonusNumberService {

    private final MemoryTicketRepository memoryTicketRepository;

    public BonusNumberService(MemoryTicketRepository memoryTicketRepository) {
        this.memoryTicketRepository = memoryTicketRepository;
    }

    public BonusNumber announcementBonusNumber(String input) {
        BonusNumber bonus = new BonusNumber();
        Integer bonusNumber = Integer.parseInt(input);
        bonus.setBonusNumber(bonusNumber);
        return memoryTicketRepository.announcementBonus(bonus);
    }

}
