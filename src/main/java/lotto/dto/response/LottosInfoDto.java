package lotto.dto.response;

import java.util.List;

public record LottosInfoDto(int ticket, List<List<Integer>> lottosNumbers) {

}
