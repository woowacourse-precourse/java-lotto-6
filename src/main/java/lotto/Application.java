package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static List<Lotto> lottoes;
    private static int price;
    private static int amount;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        price = getPurchasePrice();
        amount = price / 1000;
        getLottoes(amount);
    }

    private static void getLottoes(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
        for (int i = 0; i < amount; i++){
            Lotto lotto = Lotto.makeLottoWithRandomNumbers();
            lottoes.add(lotto);
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static int getPurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        int price = Integer.parseInt(input);
        isValidPrice(price);
        return price;
    }

    public static void isValidPrice(int price){
        if (isPriceDividedByThousand(price)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    public static boolean isPriceDividedByThousand(int price) {
        return price % 1000 != 0;
    }
}
