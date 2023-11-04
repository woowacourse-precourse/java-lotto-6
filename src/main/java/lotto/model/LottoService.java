package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.dto.WinningNumDTO;

public class LottoService {
    private final List<Lotto> lottos;
    private LottoService(List<Lotto> lottos){
        this.lottos = lottos;
    }
    public static LottoService buyLottos(int numberOfLotto){
        return new LottoService(createLottos(numberOfLotto));
    }
    private static List<Lotto> createLottos(int numberOfLotto){
        List<Lotto> new_lottos = new ArrayList<>();
        IntStream.range(0, numberOfLotto).forEach(i -> new_lottos.add(createLotto()));
        return new_lottos;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = pickRandomNumbers();
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private static List<Integer> pickRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public String getPurchasedLottos() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.getSelectedNumbers()).append("\n"));
        return sb.toString();
    }

    public List<Ranking> checkResult(WinningNumDTO winningNumDTO) {
        List<Ranking> rankings = new ArrayList<>();
        lottos.forEach(lotto -> {
            rankings.add(lotto.checkResult(winningNumDTO));
        });
        return rankings;
    }
}
