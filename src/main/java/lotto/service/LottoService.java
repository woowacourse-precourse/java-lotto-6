package lotto.service;

import java.util.List;
import lotto.domain.draw.DrawingMachine;
import lotto.domain.draw.DrawingResult;
import lotto.domain.draw.LottoStore;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningCombination;
import lotto.domain.money.Money;
import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningCombinationDto;
import lotto.dto.output.DrawingResultDto;
import lotto.dto.output.LottosDto;
import lotto.mapper.LottoMapper;
import lotto.repository.LottoRepository;

public class LottoService {
    private final LottoStore lottoStore;
    private final LottoRepository lottoRepository;
    private final DrawingMachine drawingMachine;

    public LottoService(LottoStore lottoStore, LottoRepository lottoRepository, DrawingMachine drawingMachine) {
        this.lottoStore = lottoStore;
        this.lottoRepository = lottoRepository;
        this.drawingMachine = drawingMachine;
    }

    public LottosDto purchaseLottoTickets(MoneyDto moneyDto) {
        Money money = LottoMapper.mapFrom(moneyDto);
        Lottos lottoTickets = lottoStore.sellLottoTickets(money);
        lottoRepository.save(lottoTickets);
        return LottoMapper.mapFrom(lottoTickets);
    }

    public DrawingResultDto calculateDrawingResult(WinningCombinationDto winningNumbers) {
        WinningCombination winningLotto = LottoMapper.mapFrom(winningNumbers);
        List<Lotto> purchasedLottos = lottoRepository.findAll();
        Lottos totalLottoTickets = Lottos.from(purchasedLottos);
        DrawingResult drawingResult = drawingMachine.draw(winningLotto, totalLottoTickets);
        return LottoMapper.mapFrom(drawingResult);
    }

}
