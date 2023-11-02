package lotto;
import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 이력해 주세요.");
        Price price = new Price(Integer.parseInt(Console.readLine()));
        int size = price.countLotto(price);
        System.out.println(size + "개를 구매했습니다.");

        Lotto[] lottos = Lotto.makeLottoNumbers(size);
        Lotto.printLottos(lottos);

        List<Integer> num = inputNumbers();
    }

    public static List<Integer> inputNumbers(){
        List<Integer> numbers = new ArrayList<>();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        makeList(numbers, input);

        System.out.println("보너스 번호를 입력해 주세요.");
        numbers.add(Integer.parseInt(Console.readLine()));

        return numbers;
    }

    public static List<Integer> makeList(List<Integer> numbers, String input) {
        for(String n : input.split(",")) {
            numbers.add(Integer.parseInt(n));
        }
        return numbers;
    }



}
