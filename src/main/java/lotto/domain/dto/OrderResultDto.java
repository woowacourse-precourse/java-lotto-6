package lotto.domain.dto;

import java.util.List;
import lotto.domain.Lotto;

public record OrderResultDto(int quantity, List<Lotto> items) {
}
