package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Tickets;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketsService {
    final int START_DIGIT = 1;
    final int END_DIGIT = 45;
    final int LOTTO_NUM = 6;
    public Tickets issue(Tickets tickets) {
        for(int i=0;i<tickets.calcTicketCount();i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(START_DIGIT, END_DIGIT, LOTTO_NUM);
            tickets.add(new Lotto(nums));
        }

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

    public WinningLotto getUserLotto(Lotto lotto, int bonusNum) {
        return new WinningLotto(lotto, bonusNum);
    }
}
