package lotto.model.lotto;

import java.util.List;

public record LottoDTO(
        List<Integer> numbers
) {
    public static LottoDTO of(Lotto lotto){
        return new LottoDTO(lotto.numbers);
    }

}
