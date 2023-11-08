package lotto;

import static lotto.io.ErrorHandler.*;


import camp.nextstep.edu.missionutils.Console;
import java.awt.PrintGraphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Play {
    int numberOfTicket;

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        String boughtAmount = Console.readLine();
        numberOfTicket = checkBoughtAmount(boughtAmount);
        MakeLottoCard lottoCard = new MakeLottoCard(numberOfTicket);
        StringBuilder jackpotNumber = new StringBuilder();
        System.out.println("당첨 번호를 입력해 주세요.");
        jackpotNumber.append(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        jackpotNumber.append(",");
        jackpotNumber.append(Console.readLine());
        List<Integer> jackpotInts = checkJackpotNumber(jackpotNumber.toString());


    }

    public int giveNumberOfTicket(String boughtAmount) {
        int boughtAmountInt = Integer.parseInt(boughtAmount);
        return boughtAmountInt / 1000;
    }

    public Integer checkBoughtAmount(String boughtAmount) {
        checkInt(boughtAmount);
        checkPositive(boughtAmount);
        checkThousands(boughtAmount);
        return giveNumberOfTicket(boughtAmount);
    }

    public List<Integer> checkJackpotNumber(String jackpotString) {
        List<String> jackpotStrings = List.of(jackpotString.replaceAll("\\s+", "").split(","));
        checkSize(jackpotStrings);
        for (String number : jackpotStrings) {
            checkInt(number);
            checkPositive(number);
        }
        List<Integer> jackpotInts = jackpotStrings.stream().map(Integer::valueOf).collect(Collectors.toList());
        validateRange(jackpotInts);
        validateRepeat(jackpotInts);
        return jackpotInts;
    }

    public List<Integer> compareAll(List<Integer> jackpotInts, List<List<Integer>> numbers) {
        List<Integer> rankings = new ArrayList<>();
        for (List<Integer> nums : numbers) {
            int ranking = givePrize(compare(jackpotInts, nums));
            rankings.add(ranking);
        }
        return rankings;
    }

    public List<Integer> compare(List<Integer> jackpotInts, List<Integer> nums) {
        int matched = 0;
        int bonusMatched = 0;
        for (Integer num : nums.subList(0, nums.size() - 1)) {
            if (jackpotInts.subList(0, jackpotInts.size() - 1).contains(num)) {
                matched++;
            }
        }
        if (jackpotInts.get(6).equals(nums.get(6))) {
            bonusMatched++;
        }
        return List.of(matched, bonusMatched);
    }

    // 여기서 enum  써야 할 듯
    public int givePrize(List<Integer> matchedResults) {
        int matched = matchedResults.get(0);
        int bonusMatched = matchedResults.get(1);
        if (matched == 6) {
            return 1;
        } else if (matched == 5 && bonusMatched == 1) {
            return 2;
        } else if (matched == 5 && bonusMatched == 0) {
            return 3;
        } else if (matched == 4) {
            return 4;
        } else if (matched == 3) {
            return 5;
        }
        return 0;
    }

    public List<Integer> alignRanking(List<Integer> rankings) {
        int first = Collections.frequency(rankings, 1);
        int second = Collections.frequency(rankings, 2);
        int third = Collections.frequency(rankings, 3);
        int fourth = Collections.frequency(rankings, 4);
        int fifth = Collections.frequency(rankings, 5);
        int zero = Collections.frequency(rankings, 0);
        return List.of(first, second, third, fourth, fifth, zero);
    }

}
