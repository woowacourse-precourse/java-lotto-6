package lotto.service;

import java.util.List;
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
        LottoPurchaseAmount amount = LottoPurchaseAmount.from(inputPurchaseAmount);
        LottoPurchaseQuantity quantity = amount.getLottoPurchaseQuantity();

        return getLottoPurchaseDto(amount, quantity);
    }

    private LottoPurchaseDto getLottoPurchaseDto(final LottoPurchaseAmount amount,
                                                 final LottoPurchaseQuantity quantity) {
        return new LottoPurchaseDto(amount.getAmount(), quantity.quantity());
    }

    @Override
    public LottosDto generateLotto(final int quantity) {
        return getLottosDto(
                Lottos.from(quantity)
        );
    }

    private LottosDto getLottosDto(final Lottos lottos) {
        List<LottoDto> lottoDtos = lottos.getLotto()
                .stream()
                .map(this::getLottoDto)
                .toList();

        return new LottosDto(lottoDtos);
    }

    private LottoDto getLottoDto(final Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }

    @Override
    public WinningResultDto generateWinningResult(
            String inputWinningNumber,
            String inputBonusNumber,
            LottosDto lottosDto
    ) {
        WinningResult winningResult = getLottos(lottosDto).getWinningResult(inputWinningNumber, inputBonusNumber);
        return getWinningDto(winningResult);
    }

    private WinningResultDto getWinningDto(final WinningResult winningResult) {
        return new WinningResultDto(
                winningResult.getFirstPlaceCount(),
                winningResult.getSecondPlaceCount(),
                winningResult.getThirdPlaceCount(),
                winningResult.getFourthPlaceCount(),
                winningResult.getFifthPlaceCount()
        );
    }

    private Lottos getLottos(final LottosDto lottosDto) {
        List<Lotto> lottos = lottosDto.lottos()
                .stream()
                .map(this::getLotto)
                .toList();
        return new Lottos(lottos);

    }

    private Lotto getLotto(final LottoDto lottoDto) {
        return new Lotto(lottoDto.numbers());
    }

    @Override
    public ReturnRateDto getReturnRate(LottoPurchaseDto lottoPurchaseDto, WinningResultDto winningResultDto) {
        ReturnRate returnRate = getWinningResult(winningResultDto)
                .getTotalWinningAmount()
                .calculateReturnRateFrom(lottoPurchaseDto.amount());
        return getReturnRateDto(returnRate);
    }

    private WinningResult getWinningResult(WinningResultDto winningResultDto) {
        return WinningResult.of(
                winningResultDto.firstPlaceCount(),
                winningResultDto.secondPlaceCount(),
                winningResultDto.thirdPlaceCount(),
                winningResultDto.fourthPlaceCount(),
                winningResultDto.fifthPlaceCount()
        );
    }

    private ReturnRateDto getReturnRateDto(ReturnRate returnRate) {
        return new ReturnRateDto(returnRate.returnRate());
    }
}
