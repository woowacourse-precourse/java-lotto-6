package lotto.service;

import java.util.List;
import java.util.Objects;
import lotto.dto.LottoDto;
import lotto.dto.LottoPurchaseDto;
import lotto.dto.LottosDto;
import lotto.dto.ReturnRateDto;
import lotto.dto.WinningResultDto;
import lotto.model.Lotto;
import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoPurchaseQuantity;
import lotto.model.Lottos;
import lotto.model.ReturnRate;
import lotto.model.WinningResult;

public class LottoService implements Service {
    private LottoService() {
    }

    public static LottoService create() {
        return new LottoService();
    }

    @Override
    public LottoPurchaseDto buyLottery(final String inputPurchaseAmount) {
        Objects.requireNonNull(inputPurchaseAmount);
        LottoPurchaseAmount amount = LottoPurchaseAmount.from(inputPurchaseAmount);
        LottoPurchaseQuantity quantity = amount.getLottoPurchaseQuantity();

        return getLottoPurchaseDto(amount, quantity);
    }

    private LottoPurchaseDto getLottoPurchaseDto(final LottoPurchaseAmount amount,
                                                 final LottoPurchaseQuantity quantity) {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(quantity);
        return new LottoPurchaseDto(amount.getAmount(), quantity.quantity());
    }

    @Override
    public LottosDto generateLotto(final int quantity) {
        return getLottosDto(
                Lottos.from(quantity)
        );
    }

    private LottosDto getLottosDto(final Lottos lottos) {
        Objects.requireNonNull(lottos);
        List<LottoDto> lottoDtos = lottos.getLotto()
                .stream()
                .map(this::getLottoDto)
                .toList();

        return new LottosDto(lottoDtos);
    }

    private LottoDto getLottoDto(final Lotto lotto) {
        Objects.requireNonNull(lotto);
        return new LottoDto(lotto.getNumbers());
    }

    @Override
    public WinningResultDto generateWinningResult(
            String inputWinningNumber,
            String inputBonusNumber,
            LottosDto lottosDto
    ) {
        Objects.requireNonNull(inputWinningNumber);
        Objects.requireNonNull(inputBonusNumber);
        Objects.requireNonNull(lottosDto);
        WinningResult winningResult = getLottos(lottosDto).getWinningResult(inputWinningNumber, inputBonusNumber);
        return getWinningDto(winningResult);
    }

    private WinningResultDto getWinningDto(final WinningResult winningResult) {
        Objects.requireNonNull(winningResult);
        return new WinningResultDto(
                winningResult.getFirstPlaceCount(),
                winningResult.getSecondPlaceCount(),
                winningResult.getThirdPlaceCount(),
                winningResult.getFourthPlaceCount(),
                winningResult.getFifthPlaceCount()
        );
    }

    private Lottos getLottos(final LottosDto lottosDto) {
        Objects.requireNonNull(lottosDto);
        List<Lotto> lottos = lottosDto.lottos()
                .stream()
                .map(this::getLotto)
                .toList();
        return Lottos.from(lottos);
    }

    private Lotto getLotto(final LottoDto lottoDto) {
        Objects.requireNonNull(lottoDto);
        return new Lotto(lottoDto.numbers());
    }

    @Override
    public ReturnRateDto getReturnRate(
            final LottoPurchaseDto lottoPurchaseDto,
            final WinningResultDto winningResultDto
    ) {
        Objects.requireNonNull(lottoPurchaseDto);
        Objects.requireNonNull(winningResultDto);
        ReturnRate returnRate = getWinningResult(winningResultDto
        )
                .getTotalWinningAmount()
                .calculateReturnRateFrom(lottoPurchaseDto.amount());
        return getReturnRateDto(returnRate);
    }

    private WinningResult getWinningResult(final WinningResultDto winningResultDto) {
        Objects.requireNonNull(winningResultDto);
        return new WinningResult(
                List.of(
                        winningResultDto.firstPlaceCount(),
                        winningResultDto.secondPlaceCount(),
                        winningResultDto.thirdPlaceCount(),
                        winningResultDto.fourthPlaceCount(),
                        winningResultDto.fifthPlaceCount()
                )
        );
    }

    private ReturnRateDto getReturnRateDto(final ReturnRate returnRate) {
        Objects.requireNonNull(returnRate);
        return new ReturnRateDto(returnRate.returnRate());
    }
}
