package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
//        Purchase purchase = new Purchase();
//        purchase.process();

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = List.of(Console.readLine().split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(numbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        System.out.println(bonus);
    }
}
