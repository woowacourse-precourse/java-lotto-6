package lotto.dto;

import java.util.List;

public record LottosInfo(List<String> numbers) {
    public String getLottoCountText() {
        return String.format("%n%s개를 구매했습니다.", numbers.size());
    }
}
