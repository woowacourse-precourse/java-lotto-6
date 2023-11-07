package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static ArrayList<Lotto> lottoTickets = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요:");
        generateLottoTickets(Console.readLine());
    }

    public static Integer convertMoneyFormat(String inputMoney) {
        Integer money = Integer.valueOf(inputMoney);
        return money;
    }
    public static Integer getQuantityOfLotto(Integer money) {
        Integer quantityOfLotto = money/1000;
        return quantityOfLotto;
    }
    public static void generateLottoTickets(String inputMoney) {
        Integer money= convertMoneyFormat(inputMoney);
        Integer quantityOfLotto = getQuantityOfLotto(money);
        for (int i = 0; i<quantityOfLotto; i++) {
            lottoTickets.add(generateLotto());
        }
    }
    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(null);
        return new Lotto(numbers);
    }

}
