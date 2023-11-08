package lotto.application;

import static lotto.contents.ContentNumbers.LOTTO_PRICE;
import static lotto.contents.ContentNumbers.ZERO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoDto;
import lotto.dto.WinningNumbersDto;

public class LottoService {
    private final LottoMachine lottoMachine;
    private final List<Lotto> lottos;
    private LottoResult lottoResult;
    private WinningNumbers winningNumbers;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
        this.lottos = new ArrayList<>();
    }

    public void purchaseLottoTickets(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / LOTTO_PRICE.getNumber();
        lottos.addAll(
                IntStream.range(ZERO.getNumber(), numberOfLottos)
                        .mapToObj(num -> lottoMachine.generateLotto())
                        .toList()
        );
    }

    public void processWinningNumbers(List<Integer> winningNumbersInput, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbersInput, bonusNumber);
        this.lottoResult = new LottoResult();
        lottoResult.calculateResults(getLottoDtos(), winningNumbers.toDto());
    }

    public List<LottoDto> getLottoDtos() {
        return lottos.stream()
                .map(Lotto::toDTO)
                .toList();
    }

    public WinningNumbersDto getWinningNumbersDto() {
        return winningNumbers.toDto();
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public Map<Prize, Integer> getPrizeCount() {
        return lottoResult.getPrizeCount();
    }
}