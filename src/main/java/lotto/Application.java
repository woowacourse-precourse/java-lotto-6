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

class SingleGame {
    public List<Integer> numbers;
    public boolean bonus;
    public int rank;
    public int result;
    public int profit;
    public static final int FIRST_PROFIT = 2000000000;
    public static final int SECOND_PROFIT = 30000000;
    public static final int THIRD_PROFIT = 1500000;
    public static final int FOURTH_PROFIT = 50000;
    public static final int FIFTH_PROFIT = 5000;
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
        this.rank = compareLotto(user, lotto);
        this.bonus = compareBonus(user, lotto);
    }

    public int compareLotto(List<Integer> user, List<Integer> lotto) {
        int match = 0;
        List<Integer> subLotto = lotto.subList(0, 6);
        for (Integer userNumber : user) {
            if (subLotto.contains(userNumber)) {
                match++;
            }
        }
        return match;
    }

    public boolean compareBonus(List<Integer> user, List<Integer> lotto) {
        return user.contains(lotto.get(6));
    }
    public void computeResult(){
        if(this.rank==6){
            this.result = 1;
            this.profit = FIRST_PROFIT;
        }
        if(this.rank==5 && this.bonus){
            this.result = 2;
            this.profit = SECOND_PROFIT;
        }
        if(this.rank==5){
            this.result = 3;
            this.profit = THIRD_PROFIT;
        }
        if(this.rank==4){
            this.result = 4;
            this.profit = FOURTH_PROFIT;
        }
        if(this.rank==3){
            this.result = 5;
            this.profit = FIFTH_PROFIT;
        }
    }
}

class Game{
    public String inputPrice;
}