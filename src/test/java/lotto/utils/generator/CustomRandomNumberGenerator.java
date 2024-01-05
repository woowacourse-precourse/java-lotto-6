package lotto.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Iterator;
import java.util.List;
import lotto.constant.Constant;
import lotto.domain.lotto.Lotto;
import lotto.dto.LottoDto;
import lotto.utils.generator.RandomNumber;

public class CustomRandomNumberGenerator implements RandomNumber {

    private Iterator<LottoDto> lottoIterator;

    public void initLottos(final List<LottoDto> lottos) {
        this.lottoIterator = lottos.iterator();
    }

    public List<Integer> parseNumber(List<String> numbers) {
        return numbers
                .stream()
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public Lotto generateLotto() {
        final LottoDto lottoDto = lottoIterator.next();
        final List<String> lottoNumbers = lottoDto.getNumbers();
        return new Lotto(parseNumber(lottoNumbers));
    }
}
