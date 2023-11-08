package lotto.service.generate;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.generate.GetGeneratedLottosDto;

public class LottoGenerator implements Generator{
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int FORTY_FIVE = 45;
    private static final int SIX = 6;

    @Override
    public GetGeneratedLottosDto generateLottos(final GetLottoCountDto getLottoCountDto) {
        return new GetGeneratedLottosDto(
                generateLottosIteration(getLottoCountDto, new ArrayList<>())
        );
    }

    private static List<Lotto> generateLottosIteration(final GetLottoCountDto getLottoCountDto, final List<Lotto> lottos) {
        for(int count = ZERO; count < getLottoCountDto.getCount(); count++){
            addLottoInLottos(lottos);
        }
        return lottos;
    }

    private static void addLottoInLottos(final List<Lotto> lottos) {
        lottos.add(new Lotto(getLottoNumbers()));
    }

    private static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(ONE, FORTY_FIVE, SIX);
    }
}
