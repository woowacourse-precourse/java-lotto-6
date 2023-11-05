package lotto.controller;

import static lotto.model.SystemConstant.MAX_LOTTO_NUMBER;
import static lotto.model.SystemConstant.MIN_LOTTO_NUMBER;
import static lotto.model.SystemConstant.NUM_OF_NUMBERS;
import static lotto.view.OutputView.printLottoNumbers;
import static lotto.view.OutputView.printNumOfTickets;
import static lotto.view.SystemMessage.ASK_BONUS;
import static lotto.view.SystemMessage.ASK_MONEY;
import static lotto.view.SystemMessage.ASK_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Register;
import lotto.view.InputView;
import lotto.view.OutputView;


public class UnifiedController {
    public void inputAndStoreMoney() {
        OutputView.printSystemMessage(ASK_MONEY);
        boolean valid = false;
        while (!valid) {
            try {
                Register.money = new Money(Long.parseLong(InputView.inputLongData()));
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
                Register.winningLotto = new Lotto(covertElementStringToInteger(InputView.inputIntegerListData()));
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
                Set<Integer> winningNumbers = new HashSet<>(Register.winningLotto.getNumbers());
                Register.bonus = new Bonus(Integer.parseInt(InputView.inputIntegerData()), winningNumbers);
                valid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
