package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = inputPrice();
        Lotto lotto = new Lotto(inputUserNumbers());
        List<Integer> numbers = lotto.getLotto();
        int bonus = inputBonus();
    }
    private static int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        try {
            price = Integer.parseInt(Console.readLine());
            validate(price);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 유효하지 않는 값입니다. 가격은 1000원 단위로 입력할 수 있습니다.");
        }

        return price;
    }
    private static List<Integer> inputUserNumbers() {
        String input;

        System.out.println("당첨 번호를 입력해 주세요.");
        input = Console.readLine();
        List<String> strNum = new ArrayList<String>(Arrays.asList(input.split(",")));
        List<Integer> numbers = strNum.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        return numbers;
    }
    private static int inputBonus(){
        System.out.println("구입금액을 입력해 주세요.");
        int bonus = 0;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
        }

        return bonus;
    }
    private static void validate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}