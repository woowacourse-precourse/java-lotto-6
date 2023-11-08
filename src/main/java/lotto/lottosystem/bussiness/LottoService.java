package lotto.lottosystem.bussiness;

import lotto.lottosystem.presentation.printer.StatisticsVO;
import lotto.lottosystem.presentation.printer.TicketsVO;
import lotto.lottosystem.presentation.reader.MoneyVO;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int ONE_LOTTO_EXPENCE = 1000;
    private final LottoGenerator lottoGenerator;
    private Lotto answerLotto;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.answerLotto = makeAnswerLotto();
    }

    private Lotto makeAnswerLotto() {
        return new Lotto(lottoGenerator.generateLotto());
    }

    public TicketsVO issueTickets(MoneyVO moneyVO) {
        List<List<Integer>> tickets = new ArrayList<>();
        int money = moneyVO.money();
        validateMoney(money);
        int count = calcCount(money);
        for(int i = 0; i < count; i++) {
            tickets.add(lottoGenerator.generateLotto());
        }
        return new TicketsVO(tickets);
    }

    private void validateMoney(int money) {
        if ((money % ONE_LOTTO_EXPENCE) != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private int calcCount(int money) {
        return (money / ONE_LOTTO_EXPENCE);
    }

    public StatisticsVO calcStatistics() {

    }
}
