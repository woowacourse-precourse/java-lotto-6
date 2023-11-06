package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static int NUMBER = 6;
    private final String ERROR = "[ERROR]";
    private List<Lotto> lottos = new ArrayList<>();

    public void start() {
        UserInput input = new UserInput();
        int count = input.purchase();
        generateLottoNumbers(count);
        input.luckyNumber();
        input.bonusNumber();
    }

    // 1000으로 나누어 지는지 확인
    public boolean isNotDivisibleBy1000(int amount) {
        if (amount % 1000 != 0) {
            System.out.println(ERROR + " 1000으로 나누어 떨어지는 금액을 입력하세요.");
            return false;
        }
        return true;
    }

    // 로또 번호 생성
    public List<Lotto> generateLottoNumbers(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> generateNumbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, NUMBER);
            Lotto lotto = new Lotto(generateNumbers);
            lottos.add(lotto);
        }
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getRandomNumber());
        }
        return lottos;
    }

    public void guessNumbers(List<Lotto> random, List<Lotto> lucky, int bonus){

    }
}