package lotto.controller;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.domain.dto.LottoBundleDto;
import lotto.domain.dto.LottoResultsDto;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.WinLotto;
import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.domain.player.Player;
import lotto.domain.player.Profit;
import lotto.domain.service.LottoPurchaseService;
import lotto.domain.service.LottoResultsService;
import lotto.util.ModelAndViewConverter;
import lotto.util.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String BONUS_NUMBER_DUPLICATE_ERROR = "보너스 넘버와 당첨 번호는 동일할 수 없습니다.";
    private final OutputView outputView;
    private final ModelAndViewConverter modelAndViewConverter;
    private final InputView inputView;

    public LottoController(ModelAndViewConverter modelAndViewConverter, InputView inputView, OutputView outputView) {
        this.modelAndViewConverter = modelAndViewConverter;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void doLottoGame() {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(new LottoBundle());
        LottoResultsService lottoResultsService = new LottoResultsService(new LottoResultsRepository());

        Player player = makePlayer();
        player = lottoPurchaseService.purchaseLotto(player, RandomLottoGenerator::generateRandomLotto);

        LottoBundleDto lottoBundleDto = lottoPurchaseService.makeLottoBundleDto();
        printPurchaseLotto(lottoBundleDto);

        WinLotto winLotto = makeWinLotto();
        lottoResultsService.updateLottoResultRepository(lottoBundleDto,winLotto);
        LottoResultsDto lottoResultsDto = lottoResultsService.makeLottoResultsDto();

        printWinning(lottoResultsDto);
        checkAndPrintProfit(player, lottoResultsDto);
    }

    private Player makePlayer() {
        return repeat(() -> new Player(inputView.inputPurchaseMoney()), modelAndViewConverter);
    }

    private void printPurchaseLotto(LottoBundleDto lottoBundleDto) {
        modelAndViewConverter.addComponent(lottoBundleDto);
        outputView.printTotalNumberOfLotto(modelAndViewConverter);
        outputView.printTotalLotto(modelAndViewConverter);
    }

    private WinLotto makeWinLotto() {
        Lotto lotto = repeat(this::makeLotto, modelAndViewConverter);
        BonusNumber bonusNumber = repeat(this::makeBonusNumber,lotto, modelAndViewConverter);
        return new WinLotto(lotto, bonusNumber);
    }

    private Lotto makeLotto() {
        return new Lotto(inputView.inputWinLottoNumber());
    }

    private BonusNumber makeBonusNumber(Lotto lotto) {
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
        if (bonusNumber.checkLottoContainBonusNumber(lotto)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR);
        }
        return bonusNumber;
    }

    private void printWinning(LottoResultsDto lottoResultsDto) {
        modelAndViewConverter.addComponent(lottoResultsDto);
        outputView.printLottoResultsData(modelAndViewConverter);
    }

    private void checkAndPrintProfit(Player player, LottoResultsDto lottoResultsDto){
        Profit profit = player.getProfit(lottoResultsDto);
        modelAndViewConverter.addComponent(profit);
        outputView.printProfit(modelAndViewConverter);
    }

    private <T> T repeat(Supplier<T> something, ModelAndViewConverter modelAndViewConverter) {
        try {
            return something.get();
        } catch (IllegalArgumentException e) {
            modelAndViewConverter.addComponent(e);
            outputView.printError(modelAndViewConverter);
            return repeat(something, modelAndViewConverter);
        }
    }

    private <T, R> R repeat(Function<T, R> something, T input, ModelAndViewConverter modelAndViewConverter) {
        try {
            return something.apply(input);
        } catch (IllegalArgumentException e) {
            modelAndViewConverter.addComponent(e);
            outputView.printError(modelAndViewConverter);
            return repeat(something,input, modelAndViewConverter);
        }
    }
}
