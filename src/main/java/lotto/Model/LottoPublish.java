package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPublish {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS = 6;
    private final List<Lotto> lottoPublish;

    public LottoPublish(int number) {
        List<Lotto> lottoPublish = new ArrayList<>();
        while (lottoPublish.size() < number){
            lottoPublish.add(makingLotto());
        }
        this.lottoPublish = lottoPublish;
    }

    public List<Lotto> getLottoPublish() {
        return lottoPublish;
    }

    private Lotto makingLotto(){
        return new Lotto(organizeLottoNumbers(generateRandomNumbers()));
    }
    private List<Integer> organizeLottoNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS);
    }

}
