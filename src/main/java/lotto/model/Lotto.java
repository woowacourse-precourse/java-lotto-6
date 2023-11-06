package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_TICKET_SIZE = 6;

    private final List<LottoNumber> lottoTickets;

    public Lotto(String lottoNumbers) {
        this.lottoTickets = parseLottoNumbers(lottoNumbers);
    }

    public Lotto(List<LottoNumber> lottoTickets) {
        validateLottoSize(lottoTickets);
        validateLottoDuplication(lottoTickets);
        this.lottoTickets = lottoTickets;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public List<LottoNumber> parseLottoNumbers(String lottoNumbers) {

        return Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(number -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

    private void validateLottoSize(List<LottoNumber> lottoTickets) {
        if (lottoTickets.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
        }
    }

    private void validateLottoDuplication(List<LottoNumber> lottoTickets) {
        long count = lottoTickets.stream().distinct().count();

        if (count != lottoTickets.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다.");
        }
    }
}
