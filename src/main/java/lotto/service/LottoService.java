package lotto.service;

import java.util.List;
import lotto.domain.draw.DrawingMachine;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.WinningLotto;
import lotto.dto.LottoNumberDto;
import lotto.dto.input.BonusNumberDto;
import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningNumbersDto;
import lotto.dto.output.LottosDto;

// todo : Mapper 만들기 -> 변환용
public class LottoService {
    private final DrawingMachine drawingMachine;

    public LottoService(DrawingMachine drawingMachine) {
        this.drawingMachine = drawingMachine;
    }

    // ref. 메소드 분리
    private WinningLotto of(WinningNumbersDto winningNumbersDto, BonusNumberDto bonusNumberDto) {
        // 당첨번호
        List<LottoNumberDto> lottoWinningNumberDtos = winningNumbersDto.winningNumbers();
        List<Integer> numbers = lottoWinningNumberDtos.stream()
                .map(LottoNumberDto::number)
                .toList();
        Lotto winningNumber = Lotto.from(numbers);

        // 보너스 번호
        LottoNumberDto lottoBonusNumberDto = bonusNumberDto.bonusNumber();
        int number = lottoBonusNumberDto.number();
        BonusNumber bonusNumber = BonusNumber.from(number);
        return WinningLotto.from(winningNumber, bonusNumber);
    }

    public LottosDto drawLottoTicketsWithGivenMoney(MoneyDto moneyDto) {
        Money money = from(moneyDto);
        Lottos lottos = drawingMachine.drawLottoTicketsWithGivenMoney(money);
        return from(lottos);
    }

    private LottosDto from(Lottos lottos) {
        return LottosDto.from(lottos);
    }

    private Money from(MoneyDto moneyDto) {
        int money = moneyDto.money();
        return Money.fromInitialMoney(money);
    }
}
