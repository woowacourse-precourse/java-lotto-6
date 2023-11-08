package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private List<Lotto> lottoList; // 로또 리스트
    private int purchaseQuantity; // 구매한 로또 티켓 수량
    private int purchaseAmount; // 구매금액

    public LottoTicket(int purchaseAmount) {
        // 사용자로부터 입력된 금액으로 로또 티켓 수량을 계산하고 필드에 저장
        this.purchaseAmount = purchaseAmount;
        this.purchaseQuantity = purchaseAmount / AppConstants.LOTTO_LENGTH;
        this.lottoList = publishLotto();
    }
    private List<Lotto> publishLotto() {
        // Lotto 객체 생성 및 저장
        List<Lotto> result = new ArrayList<>();
        for (int i=0; i< purchaseQuantity; i++) {
            List<Integer> list = getUniqueNumbersList();
            Lotto lotto = new Lotto(list);
            result.add(lotto);
        }
        return result;
    }

    private List<Integer> getUniqueNumbersList() {
        // 범위 내 랜덤 값 반환
        return Randoms.pickUniqueNumbersInRange(AppConstants.RANDOM_RANGE_MIN,
                AppConstants.RANDOM_RANGE_MAX, AppConstants.LOTTO_LENGTH);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }
}