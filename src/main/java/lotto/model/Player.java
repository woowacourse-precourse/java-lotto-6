package lotto.model;

import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.GameConstant.*;

public class Player {
    private final int INITIAL_VALUE = 0;
    private List<Lotto> lottos;
    private List<Result> results;

    protected Player(int length) {
        this.lottos = new ArrayList<>(length);
        this.results = initResults();
    }

    protected void addLotto(List<Integer> lotto) {
        this.lottos.add(new Lotto(lotto));
    }

    protected List<LottoDto> getLottoNumbers() {
        return lottos.stream().map(value -> LottoDto.toDto(value.getNumbers())).toList();
    }

    protected void updateResult(int grade) {
        this.results.get(grade - 1).addCount();
    }

    protected List<Integer> getResults() {
        return this.results.stream().map(Result::getCount).toList();
    }

    private List<Result> initResults() {
        List<Result> result = new ArrayList<>();

        for(int index = INITIAL_VALUE; index < CONSTANT_GRADE_LENGTH.getConstant(); index++) {
            result.add(new Result());
        }

        return result;
    }
}