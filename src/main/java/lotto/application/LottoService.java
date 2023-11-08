package lotto.application;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.DrawResult;
import lotto.domain.LottoChecker;
import lotto.domain.LottoResult;
import lotto.domain.LottoReward;
import lotto.domain.LottoStatistic;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.Ticket;
import lotto.domain.TicketSeller;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    private TicketSeller ticketSeller;
    private List<Ticket> tickets;
    private LottoChecker lottoChecker;
    private LottoStatistic lottoStatistic;
    private LottoReward lottoReward;

    public LottoService() {
        this.ticketSeller = new TicketSeller(new RandomLottoGenerator());
    }

    private int parseMoney(String money) {
        int moneyInt = 0;
        try {
            moneyInt = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력 가능합니다.");
        }
        if (moneyInt % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력 가능합니다.");
        }
        return moneyInt;
    }

    public List<Ticket> buyLotto(String moneyText) {
        int numberOfTickets = parseMoney(moneyText) / LOTTO_PRICE;
        tickets = IntStream.range(0, numberOfTickets)
                .mapToObj(i -> ticketSeller.createTicket())
                .toList();
        return tickets;
    }

    private List<Integer> parseNumbers(String numbersText) {
        List<String> numbers = List.of(numbersText.split(","));
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 입력 가능합니다.");
        }
        try {
            return numbers.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다.");
        }
    }

    private int parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR}]][}{}{{");
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    public void setDrawResult(String numbersText, String bonusNumber) {
        List<Integer> numbers = parseNumbers(numbersText);
        int bonusNumberInt = parseBonusNumber(bonusNumber);

        DrawResult drawResult = new DrawResult(numbers, bonusNumberInt);
        lottoChecker = new LottoChecker(tickets, drawResult);
    }

    public LottoStatistic getLottoStatistic() {
        List<LottoResult> lottoResults = lottoChecker.checkTickets();
        lottoStatistic = new LottoStatistic(lottoResults);
        return lottoStatistic;
    }

    public LottoReward getLottoReward() {
        lottoReward = new LottoReward(lottoStatistic);
        return lottoReward;
    }
}
