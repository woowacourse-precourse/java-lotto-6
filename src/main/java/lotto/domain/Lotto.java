package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int ONE_LOTTO_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = createLotto();
        Collections.sort(lottoNumbers);
    }

    public List<LottoNumber> createLotto() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0,ONE_LOTTO_LENGTH);
    }

    public List<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
