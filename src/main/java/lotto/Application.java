package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class User {
    public List<List<Integer>> tickets;
    public String price;
    private static final int TICKET_PRICE = 1000;

    public User(String price) {
        validate(price);
        this.price = price;
    }

    private void validate(String price) {
        if (Integer.parseInt(price) % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    private List<Integer> generateTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private void purchaseTicket() {
        final int AMOUNT = Integer.parseInt(this.price) / TICKET_PRICE;
        for (int i = 0; i < AMOUNT; i++) {
            this.tickets.add(generateTicket());
        }
    }
}

class Game {
    public List<Integer> numbers;
    public String inputPrice;
    public int rank;

    public void inputLottoNumbers() {
        String[] inputNumbers;
        inputNumbers = Console.readLine().split(",");
        for (String number : inputNumbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

    public void inputBonusNumber() {
        this.numbers.add(Integer.parseInt(Console.readLine()));
    }

    public void compareNumbers(List<Integer> user, List<Integer> lotto) {

    }

    public int compareLotto(List<Integer> user, List<Integer> lotto) {
        this.rank = 0;
        List<Integer> subLotto = lotto.subList(0, 6);
        for (Integer userNumber : user) {
            if (subLotto.contains(userNumber)) {
                this.rank++;
            }
        }
        return rank;
    }

    public boolean compareBonus(List<Integer> user, List<Integer> lotto) {
        return user.contains(lotto.get(6));
    }
}