package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConfig;

import java.util.ArrayList;
import java.util.List;

public class GenerateLotto {
    private final List<Lotto> lottos;

    public GenerateLotto(int lottoCount) {
        this.lottos = generateLottoGroup(lottoCount);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    private List<Lotto> generateLottoGroup(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < lottoCount) {
            lottos.add(new Lotto(sorted(generateLottoNumbers())));
        }
        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_RANGE, LottoConfig.MAX_RANGE, LottoConfig.LOTTO_SIZE);
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}