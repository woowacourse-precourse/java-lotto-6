package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void printLottoNumbers(int ticketNumber, List<Integer> numbers){
        for (int i = 0; i < ticketNumber; i++) {
            System.out.println(numbers);
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        Collections.sort(numbers);

        printLottoNumbers(1,numbers);
    }
}
