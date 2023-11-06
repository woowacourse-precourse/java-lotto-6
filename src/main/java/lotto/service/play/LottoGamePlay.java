package lotto.service.play;

import lotto.dto.calculate.GetReturnRateDto;
import lotto.dto.domain.lottos.GetLottosDto;
import lotto.dto.generate.GetGeneratedLottosDto;
import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.input.GetWinningNumberDto;
import lotto.dto.result.GetLottoResultDto;
import lotto.service.calculate.Calculator;
import lotto.service.calculate.LottoReturnRateCalculator;
import lotto.service.generate.Generator;
import lotto.service.generate.LottoGenerator;
import lotto.service.input.Input;
import lotto.service.input.InputView;
import lotto.service.output.Output;
import lotto.service.output.OutputView;
import lotto.service.resultcheck.LottoResultCheck;
import lotto.service.resultcheck.ResultCheck;
import lotto.util.message.Printer;

public class LottoGamePlay implements GamePlay{
    private final Input input;
    private final Output output;
    private final Generator generator;
    private final Calculator calculator;
    private final ResultCheck resultCheck;

    public LottoGamePlay() {
        this.input = new InputView();
        this.output = new OutputView();
        this.generator = new LottoGenerator();
        this.calculator = new LottoReturnRateCalculator();
        this.resultCheck = new LottoResultCheck();
    }

    @Override
    public void play() {
        GetLottoCountDto lottoCountDto = input.getLottoBuyMoney();
        Printer.changeLine();
        GetGeneratedLottosDto getGeneratedLottosDto = generator.generateLottos(lottoCountDto);
        output.printLottoNumbers(getGeneratedLottosDto);
        GetWinningNumberDto winningNumber = input.getWinningNumber();
        Printer.changeLine();
        GetBonusNumberDto bonusNumber = input.getBonusNumber(winningNumber);
        Printer.changeLine();
        GetLottoResultDto lottoResult = resultCheck.getLottoResult(winningNumber, bonusNumber, new GetLottosDto(getGeneratedLottosDto.getLottos()));
        output.printLottoResult(lottoResult);
        GetReturnRateDto getReturnRateDto = calculator.calculateLottoReturnRate(lottoResult, lottoCountDto);
        output.printRate(getReturnRateDto);
    }
}
