package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Play {

    public void play() {
        int lottoAmount = purchase();
        List<Lotto> lottos = lottoNumbers(lottoAmount);

        for (Lotto list : lottos) {
            System.out.println(list.getNumbers());
        }
    }

    // 로또를 구입한다
    public int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();

        try {
            validate(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchase();
        }
        int amount = Integer.parseInt(price) / 1000;

        System.out.println("\n"+amount+"개를 구매했습니다.");

        return amount;
    }

    // 구입한 개수만큼 로또를 생성한다
    public List<Lotto> lottoNumbers(int lottoAmount) {
        List<Lotto> lottoNumbersList = new ArrayList();

        for (int i = 1; i <= lottoAmount; i++) {
            lottoNumbersList.add(new Lotto(lottoRandomNumbersProduce()));
        }
        return lottoNumbersList;
    }

    // 6개의 랜덤 숫자를 생성하고 오름차순으로 정렬한다
    public List<Integer> lottoRandomNumbersProduce() {
        List<Integer> numbers = new ArrayList<Integer>
                (Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    // 입력받은 금액이 1000원 단위가 아니면 예외 발생
    public void validate (String price) {
        try {
            Double.parseDouble(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (Double.parseDouble(price) % 1000 != 0.0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }
}
