package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ResultLottos {
    private final List<ResultLotto> resultLottos = new ArrayList<>();

    public Integer size() {
        return resultLottos.size();
    }

    public void addResultLotto(Integer equalCount, Boolean bonus) {
        ResultLotto resultLotto = Arrays.stream(ResultLotto.values())
                .filter(r -> Objects.equals(r.getEqualCount(), equalCount) && r.getBonus() == bonus)
                .findFirst()
                .orElse(ResultLotto.EMPTY);
        if (resultLotto != ResultLotto.EMPTY) {
            resultLottos.add(resultLotto);
        }
    }

    public Long findResultCount(ResultLotto resultLotto) {
        return resultLottos.stream()
                .filter(r -> r == resultLotto)
                .count();
    }

    public Long sumResult() {
        return Arrays.stream(ResultLotto.values())
                .mapToLong(resultLotto -> resultLotto.getPrize() * findResultCount(resultLotto))
                .sum();
    }
}
