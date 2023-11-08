package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.enumeration.Constants;
import lotto.enumeration.WinningType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> issue(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(
                    Constants.START_DIGIT.getConstant(),
                    Constants.END_DIGIT.getConstant(),
                    Constants.LOTTO_NUM.getConstant());
            tickets.add(new Lotto(nums));
        }
        return tickets;
    }

    public Lotto stringToLotto(String input) {
        String[] inputArray = input.split(",");
        List<Integer> lottoNums = new ArrayList<>();

        for (String str : inputArray) {
            String num = str.replaceAll("\\s", "");
            lottoNums.add(Integer.parseInt(num));
        }

        return new Lotto(lottoNums);
    }

    public WinningLotto getWinningLotto(Lotto lotto, int bonusNum) {
        return new WinningLotto(lotto, bonusNum);
    }

    public Result compare(List<Lotto> tickets, WinningLotto winningLotto) {
        Result result = new Result();
        for (Lotto ticket : tickets) {
            WinningType winningType = WinningType.compare(countDuplicateNum(ticket, winningLotto)
                    , hasBonusNum(ticket, winningLotto.getBonusNum()));
            result.update(winningType);
        }
        return result;
    }

    private boolean hasBonusNum(Lotto lotto, int bonusNum) {
        if (lotto.getNumbers().contains(bonusNum)) {
            return true;
        }
        return false;
    }

    public int countDuplicateNum(Lotto ticket, WinningLotto winningLotto) {
        int count = 0;
        for (int num : ticket.getNumbers()) {
            if (winningLotto.getNumbers().getNumbers().contains(num)) {
                count++;
            }
        }
        return count;
    }
}
