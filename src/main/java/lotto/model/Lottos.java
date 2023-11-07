package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private static final String COMMA = ",";

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<LottoResult> match(Lotto winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public static List<Integer> parseLottoNumber(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateBonusNumberDuplication(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 서로 중복될 수 없습니다.");
        }
    }
}
