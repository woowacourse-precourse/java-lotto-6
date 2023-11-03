package lotto.controller;

import static lotto.enums.NumberCondition.LOTTO_SIZE;
import static lotto.enums.NumberCondition.LOWEST_PRIZE_RANK;

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
    private User user;
    private Lotto lotto;
    private int count;
    private int bonusNumber;
    private int[] nthPrizeNumber = new int[LOWEST_PRIZE_RANK.number() + 1];

    public void progress() {
        setCount();
        setUser();
        OutputView.printCountAndTickets(user, count);
        setLotto();
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

    private void setPrizeNumber() {
        for (int i = 0; i < count; i++) {
            List<Integer> userTicket = user.getTicket(i);
            List<Integer> lottoNumber = lotto.getNumbers();
            addPrize(userTicket, differentNumberAmount(userTicket, lottoNumber));
        }
    }

    private void addPrize(List<Integer> userTicket, int differentNumberAmount) {
        if (fifthPrize(differentNumberAmount)) {
            addNthPrize(5);
        }
        if (fourthPrize(differentNumberAmount)) {
            addNthPrize(4);
        }
        if (thirdPrize(userTicket, differentNumberAmount)) {
            addNthPrize(3);
        }
        if (secondPrize(userTicket, differentNumberAmount)) {
            addNthPrize(2);
        }
        if (firstPrize(differentNumberAmount)) {
            addNthPrize(1);
        }
    }

    private int differentNumberAmount(List<Integer> userTicket, List<Integer> lottoNumber) {
        Set<Integer> comparator = new HashSet<>();
        comparator.addAll(userTicket);
        comparator.addAll(lotto.getNumbers());
        return LOTTO_SIZE.number() * 2 - comparator.size();
    }

    private boolean fifthPrize(int differentNumberAmount) {
        return differentNumberAmount == 3;
    }

    private boolean fourthPrize(int differentNumberAmount) {
        return differentNumberAmount == 2;
    }

    private boolean thirdPrize(List<Integer> userTicket, int differentNumberAmount) {
        return differentNumberAmount == 1 && !userTicket.contains(bonusNumber);
    }

    private boolean secondPrize(List<Integer> userTicket, int differentNumberAmount) {
        return differentNumberAmount == 1 && userTicket.contains(bonusNumber);
    }

    private boolean firstPrize(int differentNumberAmount) {
        return differentNumberAmount == 0;
    }

    private void addNthPrize(int n) {
        nthPrizeNumber[n]++;
    }
}