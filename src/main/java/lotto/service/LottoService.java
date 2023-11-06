package lotto.service;

import lotto.domain.AnswerLotto;
import lotto.domain.UserLotto;
import lotto.domain.WinningResult;
import lotto.dto.LottoDto;
import lotto.dto.WinningResultDto;

import java.util.List;

public class LottoService {

    private UserLotto userLotto;
    private AnswerLotto answerLotto;
    private WinningResult winningResult;

    public void buyLottos(int purchasePrice) {
        userLotto = new UserLotto(purchasePrice);
    }

    public List<LottoDto> getUserLottoDto() {
        List<LottoDto> lottoDtos = userLotto.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
        return lottoDtos;
    }

    public void drawLotto(List<Integer> winningNumbers, int bonusNumber) {
        answerLotto = new AnswerLotto(winningNumbers, bonusNumber);
    }

    public void calculateWinningResult() {
        winningResult = userLotto.calculateWinningResult(answerLotto);
    }

    public WinningResultDto getWinningResultDto() {
        return new WinningResultDto(winningResult);
    }
}
