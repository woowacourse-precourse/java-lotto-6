package lotto.controller;

import static lotto.model.Rank.FIFTH;
import static lotto.model.Rank.FIRST;
import static lotto.model.Rank.FOURTH;
import static lotto.model.Rank.SECOND;
import static lotto.model.Rank.THIRD;
import static lotto.model.SystemConstant.DataType.INTEGER;
import static lotto.model.SystemConstant.DataType.INTEGER_LIST;
import static lotto.model.SystemConstant.DataType.LONG;
import static lotto.model.SystemConstant.MAX_LOTTO_NUMBER;
import static lotto.model.SystemConstant.MIN_LOTTO_NUMBER;
import static lotto.model.SystemConstant.NUM_OF_NUMBERS;
import static lotto.view.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.view.OutputView.printLottoNumbers;
import static lotto.view.OutputView.printNumOfTickets;
import static lotto.view.SystemMessage.ASK_BONUS;
import static lotto.view.SystemMessage.ASK_MONEY;
import static lotto.view.SystemMessage.ASK_WINNING_NUMBERS;
import static lotto.view.SystemMessage.WINNING_RESULT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.Register;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.SystemMessage;


public class UnifiedController {

    public void promptData(SystemMessage systemMessage) {
        OutputView.printSystemMessage(systemMessage);
        waitForValidInput(systemMessage);
    }

    private void waitForValidInput(SystemMessage systemMessage) {
        boolean valid = false;
        while (!valid) {
            valid = checkNoException(systemMessage);
        }
    }

    private boolean checkNoException(SystemMessage systemMessage) {
        try {
            storeDataInRegister(systemMessage);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return false;
        }
    }

    private void storeDataInRegister(SystemMessage systemMessage) {
        if (systemMessage == ASK_MONEY) {
            Register.money = new Money(Long.parseLong(InputView.inputData(LONG)));
        }
        if (systemMessage == ASK_WINNING_NUMBERS) {
            Register.firstPrizeLotto = createLotto(convertElementStringToInteger(InputView.inputData(INTEGER_LIST)));
        }
        if (systemMessage == ASK_BONUS) {
            Register.bonus = createBonus(Integer.parseInt(InputView.inputData(INTEGER)));
        }
    }

    public List<Integer> convertElementStringToInteger(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String element : input.split(",")) {
            numbers.add(Integer.parseInt(element));
        }
        return numbers;
    }

    private Lotto createLotto(List<Integer> lottoNumbers) {
        if (Register.bonus != null) {
            compareBonusAndWinningNumbers(new HashSet<>(lottoNumbers), Register.bonus.getNumber());
        }
        return new Lotto(lottoNumbers);
    }

    private Bonus createBonus(int number) {
        if (Register.firstPrizeLotto != null) {
            compareBonusAndWinningNumbers(new HashSet<>(Register.firstPrizeLotto.getNumbers()), number);
        }
        return new Bonus(number);
    }

    public void compareBonusAndWinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    public void createAndStoreLottoTickets() {
        long numOfTickets = Register.money.getAmount() / 1000;
        for (int i = 0; i < numOfTickets; i++) {
            Register.lottoTickets.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUM_OF_NUMBERS)));
        }
    }

    public void displayLottoTicketsInfo() {
        printNumOfTickets(Register.lottoTickets.size());
        for (Lotto lotto : Register.lottoTickets) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoNumbers.sort(Comparator.naturalOrder());
            printLottoNumbers(lottoNumbers);
        }
    }

    public void displayResult() {
        OutputView.printSystemMessage(WINNING_RESULT);
        Map<Rank, Long> winningCountByRank = getWinningCountsByRank();
        displayWinningLottoInfoByRank(winningCountByRank);
        long totalPrizeAmount = calcTotalPrizeAmount(winningCountByRank);
        double gainPercentage = calcGainPercentage(totalPrizeAmount);
        OutputView.printGainPercentage(gainPercentage);

    }

    private Map<Rank, Long> getWinningCountsByRank() {
        Map<Rank, Long> winningCountByRank = initializeWinningCountsByRank();
        for (Lotto lotto : Register.lottoTickets) {
            int match = lotto.compareLotto(Register.firstPrizeLotto);
            if (match >= NUM_OF_NUMBERS - 3) {
                winningCountByRank.put(checkRank(match, lotto), winningCountByRank.get(checkRank(match, lotto)) + 1);
            }
        }
        return winningCountByRank;
    }

    private Map<Rank, Long> initializeWinningCountsByRank() {
        Map<Rank, Long> winningCountByRank = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningCountByRank.put(rank, 0L);
        }
        return winningCountByRank;
    }

    private Rank checkRank(int match, Lotto lotto) {
        if (match == NUM_OF_NUMBERS) {
            return FIRST;
        }
        if (match == NUM_OF_NUMBERS - 1) {
            return resultSecondAndThird(lotto);
        }
        if (match == NUM_OF_NUMBERS - 2) {
            return FOURTH;
        }
        return FIFTH;
    }

    private Rank resultSecondAndThird(Lotto lotto) {
        if (lotto.compareBonus(Register.bonus.getNumber())) {
            return SECOND;
        }
        return THIRD;
    }

    private void displayWinningLottoInfoByRank(Map<Rank, Long> winningCountByRank) {
        for (Rank rank : Rank.values()) {
            OutputView.printWinningLottosInfo(rank, winningCountByRank.get(rank));
        }
    }

    private long calcTotalPrizeAmount(Map<Rank, Long> winningCountByRank) {
        long totalPrizeAmount = 0;
        for (Rank rank : Rank.values()) {
            totalPrizeAmount += winningCountByRank.get(rank) * rank.getPrizeMoney();
        }
        return totalPrizeAmount;
    }

    private double calcGainPercentage(long totalPrizeAmount) {
        return Math.round(((double) totalPrizeAmount / Register.money.getAmount() * 100 * 10)) / 10.0;
    }

}
