package lotto.dto;

import java.util.List;

public record WinningLottoDto(List<Integer> numbers, int bonusNumber) {
}
