package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.*;

import java.util.*;

public class LottoController {

    Input input = new Input();
    Output output = new Output();
    Lotto winningNumbers;
    BonusNumber bonusNumber;
    List<Lotto> ticketList = new ArrayList<>();
    int amount;

    public void start() {
        getLottoNumbers();
        getWinningNumbers();

        int[] matchCount = new int[5];
        for (Lotto ticket : ticketList) {
            if (getIndex(ticket) == -1) continue;
            matchCount[getIndex(ticket)]++;
        }
        output.printResults(matchCount);
        output.printRevenue(getRevenue(matchCount));
    }

    void getLottoNumbers() {
        amount = input.getAmount();
        for (int i = 0; i < amount/1000; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            ticketList.add(new Lotto(numbers));
        }
        output.printTickets(ticketList);
    }

    void getWinningNumbers() {
        winningNumbers = new Lotto(input.getWinNumbers());
        bonusNumber = new BonusNumber(input.getBonusNumber(), winningNumbers);
    }

    int getIndex(Lotto ticket) {
        int matchCount = winningNumbers.countMatch(ticket);
        boolean bonusMatch = bonusNumber.isMatch(ticket);

        if (matchCount == 3) return 0;
        if (matchCount == 4) return 1;
        if (matchCount == 5 && !bonusMatch) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 6) return 4;
        return -1;
    }

    double getRevenue(int[] matchCount) {
        int sum = 0;
        for (CheckTickets idx : CheckTickets.values()) {
            sum += matchCount[idx.ordinal()] * idx.getPrize();
        }
        return (double) sum / amount * 100;
    }
}