package lotto.model;

import java.util.List;

public record LottoDTO(
        List<Integer> numbers
) {
    public static LottoDTO of(List<Integer> numbers){
        return new LottoDTO(numbers);
    }

}
