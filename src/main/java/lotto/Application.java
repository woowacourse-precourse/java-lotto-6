package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startLotto();
    }

    public static void startLotto(){
        User user = new User();
        Lotto lotto = new Lotto(getLottoNumbers());

    }

    private static int getMoney() {

        return 1;
    }

    public static List<Integer> getLottoNumbers(){
        List<Integer> numbers = new ArrayList<>();
        String[] input = Console.readLine().split(",");

        return numbers;
    }



}
