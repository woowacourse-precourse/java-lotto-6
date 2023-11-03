package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottosDto;
import lotto.dto.NumbersDto;
import lotto.dto.WinningNumberDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoService {

    public LottosDto generateLottos(LottoNumberDto dto) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < dto.numberOfLottos(); i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return new LottosDto(lottos);
    }

    public WinningNumberDto postNormalNumbers(NumbersDto dto) {
        Lotto firstLotto = new Lotto(dto.numbers());
        WinningNumber winningNumber = new WinningNumber(firstLotto);
        return new WinningNumberDto(winningNumber);
    }

    public WinningNumberDto postBonusNumber(WinningNumberDto winningNumberDto, int bonusNum) {
        WinningNumber winningNumber = winningNumberDto.winningNumber();
        HashSet<Integer> set = new HashSet<>(winningNumber.getNormalNumbers());
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45사이의 숫자여야 합니다");
        }
        if (!set.add(bonusNum)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        winningNumber.addBonusNumber(bonusNum);
        return new WinningNumberDto(winningNumber);
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
