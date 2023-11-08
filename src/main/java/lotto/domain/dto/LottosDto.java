package lotto.domain.dto;

import java.util.List;

public class LottosDto {
    private final List<String> lottosToString;

    public LottosDto(List<String> lottosToString) {
        this.lottosToString = lottosToString;
    }

    public List<String> getLottosToString() {
        return lottosToString;
    }
}
