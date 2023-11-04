package lotto.service;

import lotto.controller.dto.input.BuyLottosDto;
import lotto.controller.dto.input.DrawLottosDto;
import lotto.controller.dto.output.LottosBuyingResult;
import lotto.controller.dto.output.LottosDrawingResult;
import lotto.domain.lotto.LottoDrawingMachine;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Wallet;
import lotto.mapper.LottoMapper;
import lotto.mapper.WalletMapper;
import lotto.repository.LottoRepository;

public final class LottoService {
    private final LottoStore lottoStore;
    private final LottoRepository lottoRepository;
    private final WalletMapper walletMapper;
    private final LottoMapper lottoMapper;

    public LottoService(
            final LottoStore lottoStore,
            final LottoRepository lottoRepository,
            final WalletMapper walletMapper,
            final LottoMapper lottoMapper
    ) {
        this.lottoStore = lottoStore;
        this.lottoRepository = lottoRepository;
        this.walletMapper = walletMapper;
        this.lottoMapper = lottoMapper;
    }

    /**
     * 로또 구매 입력에 대한 Dto를 받아서 구매 로직을 처리하고, 응답을 Dto로 변환 및 반환
     */
    public LottosBuyingResult buyLottos(final BuyLottosDto dto) {
        final Wallet wallet = walletMapper.mapFrom(dto);
        final Lottos boughtLottos = lottoStore.buyUntilOutOfMoney(wallet);
        final Lottos copiedLottos = boughtLottos.clone();
        lottoRepository.saveAll(boughtLottos);

        return LottoMapper.mapFrom(copiedLottos);
    }

    /**
     * 로또 추첨에 대한 입력 Dto를 받아서 추첨 로직을 처리하고, 응답을 Dto로 변환 및 반환
     */
    public LottosDrawingResult drawAllLottos(final DrawLottosDto dto) {
        final WinningLotto winningLotto = LottoMapper.mapFrom(dto);
        final LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine(winningLotto);
        final Lottos lottos = new Lottos(lottoRepository.findAll());
        return lottoDrawingMachine.draw(lottos);
    }
}
