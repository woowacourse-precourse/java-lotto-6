package lotto.controller;

import static lotto.enums.NumberCondition.LOTTO_SIZE;
import static lotto.enums.NumberCondition.LOWEST_PRIZE_RANK;
import static lotto.enums.NumberCondition.MONEY_UNIT;
import static lotto.enums.PrizeRank.FIFTH;
import static lotto.enums.PrizeRank.FIRST;
import static lotto.enums.PrizeRank.FOURTH;
import static lotto.enums.PrizeRank.SECOND;
import static lotto.enums.PrizeRank.THIRD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Converter;
import lotto.validator.GameValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private static final int PERCENT_CONVERTER = 100;
    private final int[] nthPrizeNumber = new int[LOWEST_PRIZE_RANK.number() + 1];
    private User user;
    private Lotto lotto;
    private BigDecimal returnRate;
    private int count;
    private int bonusNumber;

    public void run() {
        setCount();
        setUser();
        OutputView.printCountAndTickets(user, count);
        setLotto();
        setBonusNumber();
        setNthPrizeNumber();
        OutputView.printPrizeDetails(nthPrizeNumber);
        calculateReturnRate();
        OutputView.printReturnRate(returnRate);
    }

    private void setCount() {
        String money = InputView.money();
        try {
            GameValidator.validateMoney(money);
            count = Converter.moneyToCount(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCount();
        }
    }

    private void setUser() {
        this.user = new User(count);
    }

    private void setLotto() {
        try {
            lotto = new Lotto(setLottoNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setLotto();
        }
    }

    private List<Integer> setLottoNumbers() {
        String numbers = InputView.lottoNumbers();
        GameValidator.validateNumbers(numbers);
        return Converter.stringToIntArray(numbers);
    }

    private void setBonusNumber() {
        String number = InputView.bonusNumbers();
        try {
            GameValidator.validateBonusNumber(number, lotto);
            bonusNumber = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber();
        }
    }

    private void setNthPrizeNumber() {
        for (int i = 0; i < count; i++) {
            List<Integer> userTicket = user.getTicket(i);
            List<Integer> lottoNumber = lotto.getNumbers();
            addPrize(userTicket, matchNumberAmount(userTicket, lottoNumber));
        }
    }

    private void addPrize(List<Integer> userTicket, int differentNumberAmount) {
        if (isNthPrize(userTicket, 5, differentNumberAmount)) {
            addNthPrize(5);
        }
        if (isNthPrize(userTicket, 4, differentNumberAmount)) {
            addNthPrize(4);
        }
        if (isNthPrize(userTicket, 3, differentNumberAmount)) {
            addNthPrize(3);
        }
        if (isNthPrize(userTicket, 2, differentNumberAmount)) {
            addNthPrize(2);
        }
        if (isNthPrize(userTicket, 1, differentNumberAmount)) {
            addNthPrize(1);
        }
    }

    private int matchNumberAmount(List<Integer> userTicket, List<Integer> lottoNumber) {
        Set<Integer> comparator = new HashSet<>();
        comparator.addAll(userTicket);
        comparator.addAll(lottoNumber);
        return LOTTO_SIZE.number() * 2 - comparator.size();
    }

    private boolean isNthPrize(List<Integer> userTicket, int n, int matchNumberAmount) {
        return switch (n) {
            case 5 -> matchNumberAmount == FIFTH.matchCondition();
            case 4 -> matchNumberAmount == FOURTH.matchCondition();
            case 3 -> matchNumberAmount == THIRD.matchCondition() && !userTicket.contains(bonusNumber);
            case 2 -> matchNumberAmount == SECOND.matchCondition() && userTicket.contains(bonusNumber);
            case 1 -> matchNumberAmount == FIRST.matchCondition();
            default -> false;
        };
    }

    private void addNthPrize(int n) {
        nthPrizeNumber[n]++;
    }

    private void calculateReturnRate() {
        BigDecimal money = new BigDecimal(count * MONEY_UNIT.number());
        BigDecimal totalPrizeMoney = new BigDecimal(totalPrizeMoney());
        BigDecimal convertToPercent = new BigDecimal(PERCENT_CONVERTER);
        returnRate = totalPrizeMoney.multiply(convertToPercent)
                .divide(money, 1, RoundingMode.HALF_UP);
    }

    private int totalPrizeMoney() {
        int totalPrizeMoney = 0;
        for (int n = 1; n <= LOWEST_PRIZE_RANK.number(); n++) {
            totalPrizeMoney += nthPrizeNumber[n] * Converter.rankToPrize(n);
        }
        return totalPrizeMoney;
    }
}