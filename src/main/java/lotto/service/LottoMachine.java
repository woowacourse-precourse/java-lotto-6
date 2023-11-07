package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    // 구입 금액을 입력받아 로또 티켓 목록을 생성하여 반환
    public List<Lotto> generateLottoTickets(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000; // 구입 금액을 토대로 구매할 로또 티켓 수 계산
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers(); // 로또 번호 생성
            lottoTickets.add(new Lotto(lottoNumbers)); // 로또 티켓 생성 및 목록에 추가
        }
        return lottoTickets;
    }

    // 로또 번호 생성 (1에서 45 범위 내에서 중복되지 않는 6개의 숫자)
    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 로또 티켓 목록과 당첨 번호, 보너스 볼을 이용하여 당첨 결과를 계산하여 반환
    public WinningResult calculateWinningResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        WinningNumbers winningNumbersWithBonus = new WinningNumbers(winningNumbers, bonusNumber);
        return WinningResult.calculate(lottoTickets, winningNumbersWithBonus);
    }
}
