package lotto.domain;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Paper;
import lotto.domain.proxy.PrizeHandler;
import lotto.utils.RandomGenerator;
import lotto.utils.StringUtils;
import lotto.view.InputView;

import java.util.List;
import java.util.Optional;

import static lotto.utils.StringUtils.toInt;
import static lotto.utils.StringUtils.toIntegerList;

public class Game {
    private Lottery lottery;
    private Paper paper;
    private Lotto winningNumbers;
    private Bonus bonusNumber;

    public void createWinningNumber(InputView inputView) {
        winningNumbers = Lotto.of(toIntegerList(inputView.readLine()));
    }

    public void createBonusNumber(InputView inputView) {
        bonusNumber = Bonus.ofAndCheckDuplicatedNumber(winningNumbers, toInt(inputView.readLine()));
    }

    public void createPaper() {
        paper = Paper.of(winningNumbers, bonusNumber);
    }


    public void createLottery(InputView inputView, RandomGenerator randomGenerator) {
        String investMoney = inputView.readLine();
        lottery = Lottery.of(investMoney, randomGenerator);
    }

    public boolean isNotBonusNumber() {
        return Optional.ofNullable(bonusNumber).isEmpty();
    }

    public boolean isNotLotteryCreated() {
        return Optional.ofNullable(lottery).isEmpty();
    }

    public boolean isNotWinningNumber() {
        return Optional.ofNullable(winningNumbers).isEmpty();
    }

    public boolean isNotPaperCreated() {
        return Optional.ofNullable(paper).isEmpty();
    }

    public void calculate(PrizeHandler prizeHandler) {
        lottery.calculate(paper, prizeHandler);
    }

    public void printLottery(InputView inputView) {
        inputView.print(lottery.toString());
    }

    public int getInvestedAmount() {
        return lottery.getAmount();
    }

    public String getLottoCount() {
        return lottery.getLottoCount();
    }
}
