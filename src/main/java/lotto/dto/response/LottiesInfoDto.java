package lotto.dto.response;

import java.util.List;

public record LottiesInfoDto(int ticket, List<List<Integer>> lottiesNumber) {

}
