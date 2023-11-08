package lotto.lottosystem.bussiness;

import lotto.lottosystem.presentation.printer.StatisticsVO;
import lotto.lottosystem.presentation.printer.TicketsVO;
import lotto.lottosystem.presentation.reader.LottoNumbersVO;
import lotto.lottosystem.presentation.reader.MoneyVO;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int ONE_LOTTO_EXPENCE = 1000;
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public TicketsVO issueTickets(MoneyVO moneyVO) {
        List<Lotto> tickets = new ArrayList<>();
        int money = moneyVO.money();
        validateMoney(money);
        int count = calcCount(money);
        for(int i = 0; i < count; i++) {
            tickets.add(new Lotto(lottoGenerator.generateLotto()));
        }
        return new TicketsVO(tickets);
    }

    private void validateMoney(int money) {
        if ((money % ONE_LOTTO_EXPENCE) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private int calcCount(int money) {
        return (money / ONE_LOTTO_EXPENCE);
    }

    public StatisticsVO calcStatistics(LottoNumbersVO userInputNumbersVO, TicketsVO userTicketsVO) {
        Lotto answerLotto = userInputNumbersVO.numbers();
        int bonusNumber = userInputNumbersVO.bonusNumber();
        List<Lotto> userTickets = userTicketsVO.tickets();

        int win3Count = 0;
        int win4Count = 0;
        int win5Count = 0;
        int win5WithBonusCount = 0;
        int win6Count = 0;

        for(Lotto ticket : userTickets) {
            LottoStatus status = calcTicketStatus(ticket, answerLotto, bonusNumber);
            if (status == LottoStatus.WIN3) { win3Count++; continue;}
            if (status == LottoStatus.WIN4) { win4Count++; continue;}
            if (status == LottoStatus.WIN5) { win5Count++; continue;}
            if (status == LottoStatus.WIN5_WITH_BONUS) { win5WithBonusCount++; continue;}
            if (status == LottoStatus.WIN6) { win6Count++;}
        }

        int totalRevenue =
                (
                    win3Count*LottoStatus.WIN3.getPrize() +
                    win4Count*LottoStatus.WIN4.getPrize() +
                    win5Count*LottoStatus.WIN5.getPrize() +
                    win5WithBonusCount*LottoStatus.WIN5_WITH_BONUS.getPrize() +
                    win6Count*LottoStatus.WIN6.getPrize()
                );

        double revenueRatio = (totalRevenue / (userTickets.size()*1000.0)) * 100.0;
        return new StatisticsVO(win3Count, win4Count, win5Count, win5WithBonusCount, win6Count, revenueRatio);
    }

    private int countMatchingNumbers(Lotto ticket, Lotto answerLotto) {
        int count = 0;
        for(Integer number : ticket.getNumbers()) {
            if (answerLotto.getNumbers().contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    private LottoStatus calcTicketStatus(Lotto ticket, Lotto answerLotto, Integer bonusNumber) {
        int count = countMatchingNumbers(ticket, answerLotto);
        boolean isBonus = ticket.getNumbers().contains(bonusNumber);
        if (count == 3) {
            return LottoStatus.WIN3;
        }
        if (count == 4) {
            return LottoStatus.WIN3;
        }
        if ((count == 5) && (!isBonus)) {
            return LottoStatus.WIN5;
        }
        if ((count == 5) && (isBonus)) {
            return LottoStatus.WIN5_WITH_BONUS;
        }
        if (count == 6) {
            return LottoStatus.WIN6;
        }
        return LottoStatus.NOT_MATCHING;
    }
}
