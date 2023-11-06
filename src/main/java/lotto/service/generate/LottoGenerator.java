package lotto.service.generate;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.generate.GetGeneratedLottosDto;

public class LottoGenerator implements Generator{
    private static final int ZERO = 0;

    @Override
    public GetGeneratedLottosDto generateLottos(GetLottoCountDto getLottoCountDto) {
        return new GetGeneratedLottosDto(
                generateLottosIteration(getLottoCountDto, new ArrayList<>())
        );
    }

    private static List<Lotto> generateLottosIteration(GetLottoCountDto getLottoCountDto, List<Lotto> lottos) {
        for(int count = ZERO; count < getLottoCountDto.getCount(); count++){
            addLottoInLottos(lottos);
        }
        return lottos;
    }

    private static void addLottoInLottos(List<Lotto> lottos) {
        lottos.add(new Lotto(getLottoNumbers()));
    }

    private static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
