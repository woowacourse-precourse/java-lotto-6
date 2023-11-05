package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

        // 기능1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 1장 당 1000원의 로또를 발행해야 한다.
        // 1000원으로 나눠 떨어지지 않는 경우 예외처리를 한다.
        public static List<Lotto> buyLottos(int amount) {
                if(amount % 1000 != 0) {
                        throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 가능합니다.");
                }
                int numberOfLottos = amount / 1000;
                List<Lotto> lottos = new ArrayList<>();
                for (int i = 0; i < numberOfLottos; i++) {

                }
                return lottos;
        }
}
