package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static final String START = "구입금액을 입력해 주세요.";
    private static final int LOTTO_PRICE = 1000;
    private static final String PURCHASE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static void main(String[] args) {
        System.out.println(START);
        int amount = Integer.parseInt(readLine());
        int numberOfLotto = amount / LOTTO_PRICE;

        System.out.println();
        System.out.println(numberOfLotto + PURCHASE);
        List<Lotto> lottos = createLotto(numberOfLotto);
        printLotto(lottos);
    }

    public static List<Lotto> createLotto(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lotto = Lotto.randomNumber();
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
