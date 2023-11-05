package lotto.controller;

import static lotto.view.OutputView.printLottoNumbers;
import static lotto.view.OutputView.printNumOfTickets;
import static lotto.view.SystemMessage.ASK_MONEY;
import static lotto.view.SystemMessage.ASK_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
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
            Register.lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
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
//                Register.winningNumbers.add(InputView.);
                valid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
