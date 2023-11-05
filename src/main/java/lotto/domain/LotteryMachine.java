package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;

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

        // TODO: validate input
        String[] split = input.split(",");

        return Arrays.stream(split)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private int makeBonusNumber(List<Integer> luckyNumbers) {
        // TODO: 뽑은 보너스번호가 당첨번호와 겹치는지 확인
        // TODO: 뽑은 보너스 번호가 정수인지 검증
        // TODO: 뽑은 보너스 번호가 범위안에 속하는 정수인지 검증
        System.out.println("보너스 번호를 입력해주세요.");
        String number = Console.readLine();
        return Integer.parseInt(number);
    }

}
