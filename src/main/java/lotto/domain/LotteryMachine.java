package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static lotto.validator.LotteryMachineValidator.*;

public class LotteryMachine {

    private LotteryMachine() { }

    public static LotteryMachine of() {
        return new LotteryMachine();
    }

    public LuckyTicket makeLuckyTicket() {
        List<Integer> numbers = makeLuckyNumbers();
        int bonusNumber = makeBonusNumber(numbers);
        return LuckyTicket.of(new Lotto(numbers), bonusNumber);
    }
    private List<Integer> makeLuckyNumbers() {
        System.out.println("당첨 번호를 입력해주세요");
        String input = Console.readLine();
        validateLuckyNumber(input);
        // TODO: validate input
        String[] split = input.split(",");

        return Arrays.stream(split)
            .map(Integer::parseInt)
            .toList();
    }


    private int makeBonusNumber(List<Integer> luckyNumbers) {
        System.out.println("보너스 번호를 입력해주세요.");
        String number = Console.readLine();
        validateBonusNumber(luckyNumbers, number);
        return Integer.parseInt(number);
    }

}
