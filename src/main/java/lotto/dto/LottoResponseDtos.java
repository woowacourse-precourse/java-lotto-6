package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class LottoResponseDtos {
    private final List<LottoResponseDto> lottoResponseDtos;

    public LottoResponseDtos(List<LottoResponseDto> lottoResponseDtos) {
        this.lottoResponseDtos = lottoResponseDtos;
    }

    public List<LottoResponseDto> getLottoResponseDtos() {
        return lottoResponseDtos;
    }

    public static class LottoResponseDto {
        private final List<Integer> lottoNumbers;

        public LottoResponseDto(List<Integer> lottoNumbers) {
            this.lottoNumbers = lottoNumbers;
        }

        public List<Integer> getLottoNumbers() {
            return lottoNumbers;
        }
    }
}
