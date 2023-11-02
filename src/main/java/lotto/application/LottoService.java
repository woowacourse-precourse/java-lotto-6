package lotto.application;

import static lotto.contents.ContentNumbers.LOTTO_PRICE;
import static lotto.contents.ContentNumbers.ZERO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.dto.LottoDto;

public class LottoService {

    private final LottoMachine lottoMachine;
    private final List<Lotto> lottos;
    private LottoResult lottoResult;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
        this.lottos = new ArrayList<>();
    }

    //입력검증으로 들어오기에 검증할 필요없음
    public void purchaseLottoTickets(int purchaseAmount) {
        // 로또 구입 금액에 따라 로또 티켓을 생성한다
        int numberOfLottos = purchaseAmount / LOTTO_PRICE.getNumber();
        lottos.addAll(
                IntStream.range(ZERO.getNumber(), numberOfLottos)
                        .mapToObj(num -> lottoMachine.generateLotto())
                        .toList()
        );
    }

    public List<LottoDto> getLottoDtos() {
        return lottos.stream()
                .map(Lotto::toDTO)
                .toList();
    }
}