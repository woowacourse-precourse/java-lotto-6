package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.enumeration.WinningType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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

    public BigDecimal calcProfitRate(int amount, Result result) {
        int totalPrize = getTotalPrize(result);
        double profit = ((double) totalPrize / amount) * 100;

        return roundDouble(profit);
    }

    public int getTotalPrize(Result result) {
        int totalPrize = 0;
        for (WinningType winningType : WinningType.values()) {
            totalPrize += result.getResult().get(winningType) * winningType.getPrize();
        }
        return totalPrize;
    }

    private BigDecimal roundDouble(double value) {
        return new BigDecimal(value).setScale(1, RoundingMode.HALF_UP);
    }

    public void printWinningStat(Result result) {
        for(WinningType winningType : WinningType.values()) {
            if(winningType == WinningType.MISS) {
                continue;
            }
            int matchedCount = winningType.getMatchedCount();
            String prize = formatWithComma(winningType.getPrize());
            int count = result.getResult().get(winningType);
            if(winningType == WinningType.SECOND) {
                System.out.println(
                        matchedCount + "개 일치, 보너스 볼 일치 (" + prize + "원) - " + count + "개"
                );
                continue;
            }
            System.out.println(
                    matchedCount + "개 일치 (" + prize + "원) - " + count + "개"
            );
        }
    }

    private String formatWithComma(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }
}
