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
    public int computeResult(){
        if(this.rank==6){
            return 1;
        }
        if(this.rank==5 && this.bonus){
            return 2;
        }
        if(this.rank==5){
            return 3;
        }
        if(this.rank==4){
            return 4;
        }
        if(this.rank==3){
            return 5;
        }
        return 0;
    }
}

class Game{
    public String inputPrice;
}