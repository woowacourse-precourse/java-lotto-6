package lotto.domain.dto.output;

import java.util.List;

public record LottosDto(List<LottoDto> lottoNumbers, int quantity) {
}
