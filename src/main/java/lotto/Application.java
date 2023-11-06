package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void printLottoNumbers(int ticketAmount, List<Integer> numbers){
        for (int i = 0; i < ticketAmount; i++) {
            System.out.println(numbers);
        }
    }
    public static int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }
    public static int getLotteryTickets(int money, int PRICE){
        int amount = money / PRICE;
        return amount;
    }

    public static void checkValidatePrice(int money,int PRICE){
        try {
            if (money % PRICE != 0)
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 구매금액이 나누어 떨어지지 않습니다.");
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        Collections.sort(numbers);

        final int PRICE = 1000;
        int ticketAmount = getLotteryTickets(getMoney(),PRICE);
        checkValidatePrice(getMoney(),PRICE);

        printLottoNumbers(ticketAmount,numbers);


    }
}
