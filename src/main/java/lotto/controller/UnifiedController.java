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


public class UnifiedController {
    public void inputAndStoreMoney() {
        OutputView.printSystemMessage(ASK_MONEY);
        boolean valid = false;
        while (!valid) {
            try {
                Register.money = new Money(Long.parseLong(InputView.inputData(LONG)));
                valid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public void printLottoTicketsInfo() {
        long numOfTickets = Register.money.getAmount() / 1000;
        printNumOfTickets(numOfTickets);
        for (int i = 0; i < numOfTickets; i++) {
            Register.lottoTickets.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUM_OF_NUMBERS)));
        }
        for (Lotto lotto : Register.lottoTickets) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoNumbers.sort(Comparator.naturalOrder());
            printLottoNumbers(lottoNumbers);
        }
    }

    public void inputAndStoreWinningNumbers() {
        OutputView.printSystemMessage(ASK_WINNING_NUMBERS);
        boolean valid = false;
        while (!valid) {
            try {
                Register.firstPrizeLotto = new Lotto(covertElementStringToInteger(InputView.inputData(INTEGER_LIST)));
                valid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public List<Integer> covertElementStringToInteger(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String element : input.split(",")) {
            numbers.add(Integer.parseInt(element));
        }
        return numbers;
    }

    public void inputAndStoreBonus() {
        OutputView.printSystemMessage(ASK_BONUS);
        boolean valid = false;
        while (!valid) {
            try {
                Set<Integer> firstPrizeNumbers = new HashSet<>(Register.firstPrizeLotto.getNumbers());
                Register.bonus = new Bonus(Integer.parseInt(InputView.inputData(INTEGER)), firstPrizeNumbers);
                valid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public void printResult() {
        Map<Rank, Long> winningLottos = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningLottos.put(rank, 0L);
        }
        for (Lotto lotto : Register.lottoTickets) {
            int match = lotto.compareLotto(Register.firstPrizeLotto);
            if (match >= NUM_OF_NUMBERS - 3) {
                winningLottos.put(checkRank(match, lotto), winningLottos.get(checkRank(match, lotto)) + 1);
            }
        }
        OutputView.printSystemMessage(WINNING_RESULT);
        for (Rank rank : Rank.values()) {
            OutputView.printWinningLottosInfo(rank, winningLottos.get(rank));
        }
        long totalPrizeAmount = 0;
        for (Rank rank : Rank.values()) {
            totalPrizeAmount += winningLottos.get(rank) * rank.getPrizeMoney();
        }
        double gainPercentage = Math.round(
                ((double) totalPrizeAmount / Register.money.getAmount() * 100 * 10)) / 10.0;
        OutputView.printGainPercentage(gainPercentage);

    }

    public Rank checkRank(int match, Lotto lotto) {
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

    public Rank resultSecondAndThird(Lotto lotto) {
        if (lotto.compareBonus(Register.bonus.getNumber())) {
            return SECOND;
        }
        return THIRD;
    }
}
