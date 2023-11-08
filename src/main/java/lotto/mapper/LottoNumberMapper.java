package lotto.mapper;

import lotto.dto.LottoNumberDto;
import lotto.model.Lottos;
import java.util.ArrayList;
import java.util.List;

public class LottoNumberMapper {
    public static List<LottoNumberDto> mapToDtos(Lottos lottos) {
        List<LottoNumberDto> lottoNumberDtos = new ArrayList<>();
        lottos.forEach(lotto -> {
            lottoNumberDtos.add(new LottoNumberDto(lotto.getNumbers()));
        });
        return lottoNumberDtos;
    }
}
