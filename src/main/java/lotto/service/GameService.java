package lotto.service;

import lotto.dto.GameDto;
import lotto.dto.LottoDto;
import lotto.model.Game;
import lotto.util.LottoNumberFactory;
import lotto.util.NumberFactory;

import java.util.List;

import static lotto.util.LottoResult.*;

public class GameService {
    private final NumberFactory numberFactory;

    public GameService(LottoNumberFactory lottoNumberFactory) {
        this.numberFactory = lottoNumberFactory;
    }

    public List<LottoDto> purchaseLotto(Game game) {
        int lottoQuantity = game.getLottoQuantity();

        for(int lotto = 0; lotto < lottoQuantity; lotto++) {
            List<Integer> numbers = numberFactory.getNumbers();
            game.buyLotto(numbers);
        }

        return game.getLottoNumbers();
    }

    public GameDto getLottoResult(Game game, List<Integer> winnerNumber, int bonusNumber) {
        List<LottoDto> lottoNumbers = game.getLottoNumbers();

        for(LottoDto dto : lottoNumbers) {
            long matchedNumber = getMatchedLottoNumber(dto.getLottoNumber(), winnerNumber);
            boolean bonusResult = getBonusResult(dto.getLottoNumber(), bonusNumber);
            int grade = getGrade(matchedNumber, bonusResult);
            game.winTheGame(grade);
        }

        return new GameDto(game);
    }

    private long getMatchedLottoNumber(List<Integer> myLotto, List<Integer> winnerNumber) {
        return myLotto.stream().filter(winnerNumber::contains).count();
    }

    private boolean getBonusResult(List<Integer> myLotto, int bonusNumber) {
        return myLotto.contains(bonusNumber);
    }
}
