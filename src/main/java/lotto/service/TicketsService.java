package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.enumeration.WinningType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketsService {
    final int START_DIGIT = 1;
    final int END_DIGIT = 45;
    final int LOTTO_NUM = 6;
    final int TICKET_PRICE = 1000;

    public List<Lotto> issue(int amount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < amount / TICKET_PRICE; i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(START_DIGIT, END_DIGIT, LOTTO_NUM);
            tickets.add(new Lotto(nums));
        }

        tickets.stream().forEach(Lotto::printNumbers);

        return tickets;
    }

    public Lotto stringToLotto(String input) {
        String[] inputArray = input.split(",");
        List<Integer> lottoNums = new ArrayList<>();
        for (String str : Arrays.asList(inputArray)) {
            lottoNums.add(Integer.parseInt(str));
        }

        return new Lotto(lottoNums);
    }

    public WinningLotto getWinningLotto(Lotto lotto, int bonusNum) {
        return new WinningLotto(lotto, bonusNum);
    }

    public Result compare(List<Lotto> tickets, WinningLotto winningLotto) {
        Result result = new Result();
        for(Lotto ticket: tickets) {
            WinningType winningType = WinningType.compare(countDuplicateNum(ticket, winningLotto)
                    ,hasBonusNum(ticket, winningLotto.getBonusNum()));
            result.update(winningType);
        }
        return result;
    }

    private boolean hasBonusNum(Lotto lotto, int bonusNum) {
        if(lotto.getNumbers().contains(bonusNum)) {
            return true;
        }
        return false;
    }

    public int countDuplicateNum(Lotto ticket, WinningLotto winningLotto) {
        int count = 0;
        for(int num : ticket.getNumbers()) {
            if(winningLotto.getNumbers().getNumbers().contains(num)) {
                count++;
            }
        }
        return count;
    }
}
