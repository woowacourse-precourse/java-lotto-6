package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.dto.LottoResponseDto;
import lotto.controller.dto.LottoResponseDtos;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }

    public int size() {
        return lottos.size();
    }

    public LottoResponseDtos toResponseDtos() {
        List<LottoResponseDto> dtos = mapToLottoResponseDto();
        return new LottoResponseDtos(dtos);
    }

    private List<LottoResponseDto> mapToLottoResponseDto() {
        return lottos.stream()
                .map(Lotto::toResponseDto)
                .collect(Collectors.toList());
    }

}
