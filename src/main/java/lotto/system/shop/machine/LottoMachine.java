package lotto.system.shop.machine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.core.lottoBall.domain.LottoBall;
import lotto.core.lottoBall.domain.LottoBalls;
import lotto.core.lottoBall.domain.match.MatchLottoResult;
import lotto.system.shop.domain.Machine;
import lotto.system.shop.domain.LottoRank;
import lotto.system.shop.domain.ticket.lotto.Lotto;
import lotto.system.shop.domain.ticket.lotto.LottoTicket;
import lotto.system.shop.exception.machine.AlreadyInitializeException;
import lotto.system.shop.exception.machine.DuplicatedBonusNumberException;
import lotto.system.shop.exception.machine.DuplicatedLottoNumberException;
import lotto.system.shop.exception.machine.InvalidLottoPurchaseAmountException;
import lotto.system.shop.exception.machine.NotInitializeException;

public class LottoMachine implements Machine<LottoTicket, LottoRank> {

    private static final String ALREADY_INITIALIZE_BALLS_MESSAGE = "[ERROR] 이미 로또 번호가 설정되었습니다.";
    private static final String ALREADY_INITIALIZE_BONUS_MESSAGE = "[ERROR] 이미 보너스 번호가 설정되었습니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO_REMAIN = 0;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_SIZE = 6;

    private LottoBalls lottoBalls;
    private List<LottoBall> balls;
    private LottoBall bonusBall;

    @Override
    public void initialize() {
        this.lottoBalls = new LottoBalls(balls, bonusBall);
    }

    @Override
    public void set(List<Integer> source) {
        if (!Objects.isNull(balls)) {
            throw new AlreadyInitializeException(ALREADY_INITIALIZE_BALLS_MESSAGE);
        }
        List<LottoBall> balls = getBalls(source);
        this.balls = balls;
    }

    private List<LottoBall> getBalls(List<Integer> numbers) {
        List<LottoBall> balls = new ArrayList<>();
        List<Integer> source = new ArrayList<>();
        for (Integer number : numbers) {
            isDuplicate(source, number);
            balls.add(new LottoBall(number));
        }
        return balls;
    }

    private void isDuplicate(List<Integer> source, Integer number) {
        if (source.contains(number)) {
            throw new DuplicatedLottoNumberException();
        }
        source.add(number);
    }

    @Override
    public void set(Integer source) {
        if (!Objects.isNull(bonusBall)) {
            throw new AlreadyInitializeException(ALREADY_INITIALIZE_BONUS_MESSAGE);
        }
        isDuplicateBalls(source);
        this.bonusBall = new LottoBall(source);
    }

    private void isDuplicateBalls(Integer source) {
        for (LottoBall ball : balls) {
            if (ball.match(source)) {
                throw new DuplicatedBonusNumberException();
            }
        }
    }

    private void isInitialize() {
        if (Objects.isNull(lottoBalls)) {
            throw new NotInitializeException();
        }
    }

    @Override
    public LottoTicket buy() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
            LOTTO_SIZE);
        return new LottoTicket(new Lotto(numbers));
    }

    @Override
    public List<LottoTicket> buy(Integer money) {
        validateMoney(money);
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            tickets.add(buy());
        }
        return tickets;
    }

    private void validateMoney(Integer money) {
        if (!Objects.equals(money % LOTTO_PRICE, ZERO_REMAIN)) {
            throw new InvalidLottoPurchaseAmountException();
        }
    }

    @Override
    public LottoRank match(LottoTicket ticket) {
        isInitialize();
        MatchLottoResult matchResult = lottoBalls.match(ticket.getNumbers());
        return LottoRank.of(matchResult.getMatchCount(), matchResult.isBonusMatch());
    }

    @Override
    public List<LottoRank> match(List<LottoTicket> tickets) {
        isInitialize();
        List<LottoRank> ranks = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            ranks.add(match(ticket));
        }
        return ranks;
    }
}
