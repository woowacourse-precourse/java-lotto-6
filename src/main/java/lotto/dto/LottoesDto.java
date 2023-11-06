package lotto.dto;

import java.util.List;

public record LottoesDto(List<LottoDto> lottoDtos) {
    public int getLottoCount() {
        return lottoDtos.size();
    }
}
