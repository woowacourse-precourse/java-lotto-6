package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private final List<Lotto> lottos;
    public LottoService(int numberOfLotto){
        this.lottos = createLottos(numberOfLotto);
    }
    private List<Lotto> createLottos(int numberOfLotto){
        List<Lotto> new_lottos = new ArrayList<>();
        IntStream.range(0, numberOfLotto).forEach(i -> new_lottos.add(createLotto()));
        return new_lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public String printPurchasedLottos() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.getResult()).append("/n"));
        return sb.toString();
    }

}
