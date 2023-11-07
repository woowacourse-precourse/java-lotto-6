package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Lotto> lottoes = new ArrayList<>();
    public static void main(String[] args) {
        startLotto();
    }

    public static void startLotto() {
        int price = inputPrice();
        System.out.println();
        makeLottoes(price / 1000);
        printLottoes();
    }

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int price = Integer.parseInt(input);

        try {
            Exception.priceValidate(price);
        } catch (IllegalArgumentException e) {
            Exception.printException(e.getMessage());
            inputPrice();
        }

        return price;
    }

    public static void makeLottoes(int count) {
        while(true) {
            if(count == 0) break;
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoes.add(new Lotto(numbers));
            count--;
        }
    }

    public static void printLottoes() {
        System.out.println(lottoes.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoes) {
            System.out.println(lotto.getNumbers());
        }
    }
}
