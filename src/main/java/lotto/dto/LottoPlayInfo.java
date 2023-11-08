package lotto.dto;

import java.util.List;

public record LottoPlayInfo(List<Integer> drawnNumbers, int bonusNumber, int investment) {

}