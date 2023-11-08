package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.internal.configuration.GlobalConfiguration.validate;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Lotto lotto = new Lotto();

        lotto.Play();
    }

    public class InputPrice {
        final int money = 1000;
        int count;
        int total_price;
        String price = Console.readLine();

        public void trynum() {
            while(true) {
                try {
                    System.out.println("구입금액을 입력해 주세요.");
                    String price = Console.readLine();
                    total_price = Integer.parseInt(price);
                    count = total_price / money;
                    System.out.printf("%d개를 구매했습니다.", this.count);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] 숫자를 입력해 주세요.");
                    System.out.println("구입금액을 입력해 주세요.");
                    price = Console.readLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 1,000원 이상의 금액을 입력해 주세요.");
                    System.out.println("구입금액을 입력해 주세요.");
                    price = Console.readLine();
                }
                return;
            }
        }
    }

    public class RandomNums {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void getSelectNumbers() {
        List<Integer> select_numbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        select_numbers = Stream.of(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        select_numbers.add(Integer.parseInt(Console.readLine()));
        validate();
    }

    public void ViewNums() {
        for (List<Integer> number : numbers) {
            System.out.println(number);
    }

}




