package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {

    private List<Lotto> lottoTickets = new ArrayList<Lotto>();
    private List<Integer> winningNumbers = new ArrayList<Integer>();
    private Integer bonusNumber = 0;
    private List<Integer> matchingCounts = new ArrayList<Integer>(6);
    User user = new User();

    // TODO: 로또 발행하기: Amount 만큼 로또 숫자 생성하기 실행 후 당첨번호 받기
    public LottoManager() {
        int purchaseAmount = user.getPurchaseAmount();
        for (int i = 0; i < purchaseAmount; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }
        this.winningNumbers = user.getWinningNumbers();
        this.bonusNumber = user.getBonusNumber();
    }

    // TODO: 로또 숫자 생성하기: 중복되지 않는 숫자 6개
    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        System.out.println(numbers);
        return numbers;
    }
    
    // TODO: 로또 당첨 검증하기: 숫자가 맞는 만큼 Cnt 저장하기
    public void checkWinningNumbers() {


    }
    // TODO: 수익률 계산하기
}
