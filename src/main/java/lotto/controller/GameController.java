package lotto.controller;

import static lotto.enums.NumberCondition.LOWEST_PRIZE_RANK;
import static lotto.enums.PrizeRank.FIFTH;
import static lotto.enums.PrizeRank.FIRST;
import static lotto.enums.PrizeRank.FOURTH;
import static lotto.enums.PrizeRank.SECOND;
import static lotto.enums.PrizeRank.THIRD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Converter;
import lotto.validator.GameValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private static final int PERCENT_CONVERTER = 100;
    private static final int DECIMAL_PLACE = 1;
    private final int[] nthPrizeNumber = new int[LOWEST_PRIZE_RANK.number() + 1];
    private User user;
    private Lotto lotto;
    private BigDecimal returnRate;
    private int count;
    private int bonusNumber;
    private int totalPrizeMoney;

    public void run() {
        setUser();
        setCount();
        OutputView.printCountAndTickets(user, count);
        setLotto();
        setBonusNumber();
        setNthPrizeNumber();
        OutputView.printPrizeDetails(nthPrizeNumber);
        this.returnRate = calculateReturnRate(count, totalPrizeMoney);
        OutputView.printReturnRate(returnRate);
    }

    private void setUser() {
        try {
            user = new User(InputView.money());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setUser();
        }
    }

    private void setCount() {
        count = user.getCount();
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
        return Converter.stringToIntegerList(numbers);
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
            addPrize(userTicket, matchNumberAmount(userTicket, lottoNumber), bonusNumber);
        }
    }

    public int matchNumberAmount(List<Integer> userTicket, List<Integer> lottoNumber) {
        List<Integer> matchingList = userTicket.stream()
                .filter(lottoNumber::contains)
                .toList();
        return matchingList.size();
    }

    public void addPrize(List<Integer> userTicket, int matchNumberAmount, int bonusNumber) {
        if (isFifthPrize(matchNumberAmount)) {
            addNthPrize(5);
        }
        if (isFourthPrize(matchNumberAmount)) {
            addNthPrize(4);
        }
        if (isThirdPrize(userTicket, matchNumberAmount, bonusNumber)) {
            addNthPrize(3);
        }
        if (isSecondPrize(userTicket, matchNumberAmount, bonusNumber)) {
            addNthPrize(2);
        }
        if (isFirstPrize(matchNumberAmount)) {
            addNthPrize(1);
        }
    }

    private boolean isFifthPrize(int matchNumberAmount) {
        return matchNumberAmount == FIFTH.matchCondition();
    }

    private boolean isFourthPrize(int matchNumberAmount) {
        return matchNumberAmount == FOURTH.matchCondition();
    }

    private boolean isThirdPrize(List<Integer> userTicket, int matchNumberAmount, int bonusNumber) {
        return matchNumberAmount == THIRD.matchCondition() && !userTicket.contains(bonusNumber);
    }

    private boolean isSecondPrize(List<Integer> userTicket, int matchNumberAmount, int bonusNumber) {
        return matchNumberAmount == SECOND.matchCondition() && userTicket.contains(bonusNumber);
    }

    private boolean isFirstPrize(int matchNumberAmount) {
        return matchNumberAmount == FIRST.matchCondition();
    }

    private void addNthPrize(int n) {
        nthPrizeNumber[n]++;
        totalPrizeMoney += Converter.rankToPrize(n);
    }

    public BigDecimal calculateReturnRate(int count, int totalPrizeMoney) {
        BigDecimal money = new BigDecimal(Converter.countToMoney(count));
        BigDecimal earnedMoney = new BigDecimal(totalPrizeMoney);
        BigDecimal convertToPercent = new BigDecimal(PERCENT_CONVERTER);
        return earnedMoney.multiply(convertToPercent)
                .divide(money, DECIMAL_PLACE, RoundingMode.HALF_UP);
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }
}