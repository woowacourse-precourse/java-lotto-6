package mapper;

import domain.GameResult;
import domain.Lotto;
import mapper.dto.GameResultDto;
import mapper.dto.LottoDto;
import service.LottoService;

import java.util.List;

public class LottoMapper {
    private final LottoService lottoService;

    public LottoMapper(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public int buyTickets(int moneyAmount) {
        return lottoService.buyTickets(moneyAmount);
    }

    public List<LottoDto> getTickets() {
        return generateLottoDto(lottoService.getTickets());
    }

    private List<LottoDto> generateLottoDto(List<Lotto> lottoes) {
        return lottoes.stream()
                .map(
                        lotto -> new LottoDto(
                            lotto.getNumbers().stream().sorted().toList()
                        )
                )
                .toList();
    }

    public void setWinningNumber(List<Integer> winningNumbers) {
        lottoService.setWinningNumber(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        lottoService.setBonusNumber(bonusNumber);
    }

    public GameResultDto getResult() {
        return generateGameResultDto(lottoService.getResult());
    }

    private GameResultDto generateGameResultDto(GameResult gameResult) {
        return new GameResultDto(gameResult.getRateOfReturn(), gameResult.getWinningRankCount());
    }
}
