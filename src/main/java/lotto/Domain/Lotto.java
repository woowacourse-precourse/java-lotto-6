package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public int lottosize;

    public List<List<Integer>> LottoNum = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void generateLottoSize(String price) {
        Integer priceint = Integer.valueOf(price);
        lottosize=priceint/1000;
    }

    public void generateLottoNum() {
        for (int i = 0; i < lottosize; i++) {
            List<Integer> row = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            LottoNum.add(row);
        }
    }

    public List<List<Integer>> getLottoNum() {
        return LottoNum;
    }

    // TODO: 추가 기능 구현
}
