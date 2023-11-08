package lotto.dto;

import lotto.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosDto {
    private final List<LottoDto> lottosDto;

    private LottosDto(List<LottoDto> lottosNumberDto) {
        this.lottosDto = lottosNumberDto;
    }

    public static LottosDto from(Lottos lottos) {
        List<LottoDto> lottosNumberDto = lottos.getLottos().stream()
                .map(LottoDto::from)
                .collect(Collectors.toList());
        return new LottosDto(lottosNumberDto);
    }

    public List<LottoDto> getLottosDto() {
        return lottosDto;
    }

    public int getSize() {
        return lottosDto.size();
    }
}
