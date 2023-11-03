package lotto.domain;

import java.util.List;
import lotto.dto.LottoResponseDtos;
import lotto.dto.LottoResponseDtos.LottoResponseDto;
import lotto.utils.NumberUtils;
import lotto.utils.constant.LottoConstant;
import lotto.utils.message.ErrorMessage;
import lotto.validation.LottoNumberValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoNumberValidation().validate(numbers);
        this.numbers = NumberUtils.sorted(numbers);
    }

    public LottoResponseDto toResponseDto() {
        return new LottoResponseDto(numbers);
    }
}
