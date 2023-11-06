package lotto.domain;

import static lotto.config.AppConfig.getDataModel;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_SEVEN_COUNT;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_SIX_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.constant.LottoConstant;

public class Tickets {
    private List<List<Integer>> tickets = new ArrayList<>();
    private final Wallet wallet;

    public Tickets(Wallet wallet) {
        this.wallet = wallet;
    }

    public void generate() {
        this.tickets = IntStream.range(0, wallet.ticketCount())
                .mapToObj(i -> randomNumbers())
                .map(this::ascendingNumber)
                .peek(ticket -> OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, ticket))
                .collect(Collectors.toList());
    }

    private List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_START_NUMBER,
                LottoConstant.LOTTO_END_NUMBER, LottoConstant.LOTTO_PICK_NUMBER);
    }

    private List<Integer> ascendingNumber(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        return sortedNumbers;
    }

    public void save() {
        getDataModel().saveTicktet(this);
    }

    public List<Integer> matchNumber(Lotto lotto, Bonus bonus) {
        return tickets.stream()
                .map(ticket -> {
                    int lottoCount = lotto.sameTicket(ticket);
                    int bonusCount = bonus.sameTicket(ticket);
                    return matchAllCount(lottoCount, bonusCount);
                })
                .collect(Collectors.toList());
    }

    private int matchAllCount(int lottoCount, int bonusCount) {
        int sumCount = lottoCount + bonusCount;

        if (sumCount == MATCH_ALL_SIX_COUNT && lottoCount == 6) {
            sumCount = MATCH_ALL_SEVEN_COUNT;
        }

        return sumCount;
    }
}
