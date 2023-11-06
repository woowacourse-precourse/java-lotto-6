package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Application {

    public static final int LOTTO_PRICE = 1000;

    public static int getPurchaceAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int buyLotto = Integer.parseInt(Console.readLine());
        // 1000원 단위 입력 확인
        if (buyLotto % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
        return buyLotto / LOTTO_PRICE;
    }

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public static List<Integer> getWinningNumbers() {
        // 당첨번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumber = new ArrayList<>();
        // ","을 기준으로 하여 각 경주 참가자들을 Array에 임시 저장
        String[] winNumberArray = Console.readLine().split(",");
        for (String number : winNumberArray) {
            int numInt = Integer.parseInt(number);
            if (numInt < 1 || numInt > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winNumber.add(numInt);
        }
        return winNumber;
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int buyLottoAmount = getPurchaceAmount();
        List<Lotto> lottos = generateLottos(buyLottoAmount);
        List<Integer> winNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        printLottos(lottos);


    }
}
