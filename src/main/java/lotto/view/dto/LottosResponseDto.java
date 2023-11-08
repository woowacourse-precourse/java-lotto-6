package lotto.view.dto;

import java.util.List;

public record LottosResponseDto(List<List<Integer>> lottos, int lottoCount) {
}
