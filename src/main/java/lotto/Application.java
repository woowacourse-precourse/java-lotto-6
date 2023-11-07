package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static int price = 0;

    static List<Lotto> lottoes = new ArrayList<>();
    
    public static void main(String[] args) {
        startLotto();
    }

    public static void startLotto() {
        inputPrice();
        System.out.println();
        makeLottoes(price / 1000);
        printLottoes();
    }

    public static void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = Integer.parseInt(Console.readLine());

        try {
            Exception.priceValidate(input);
            price = input;
        } catch (IllegalArgumentException e) {
            Exception.printException(e.getMessage());
            inputPrice();
        }
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
