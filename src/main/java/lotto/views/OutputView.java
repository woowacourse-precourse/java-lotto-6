package lotto.views;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.message.OutputMessage;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Lotto> lottoResult = new ArrayList<>();

    public int outputPublishLotto(int inputPrice){
        int lottoCount = inputPrice / LOTTO_PRICE;
        System.out.println();
        System.out.println(String.format(OutputMessage.BUYING_RESULT, lottoCount));
        return lottoCount;
    }

    //로또 랜덤 번호 발행
    public void outputRandomNumberLotto(int lottoCount){
        lottoResult.clear();

        for(int count = 0 ; count < lottoCount; count ++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER,
                    LOTTO_NUMBER_COUNT);
            lottoResult.add(new Lotto(numbers));
        }
        outputLottoResult(lottoResult);
    }

    //중복확인
    //

    public void outputLottoResult(List<Lotto> lottoResult){
        lottoResult.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    // 로또에 중복이 없는지 체크
//    public boolean isLottoUnique(Lotto lotto) {
//        for (Lotto existingLotto : lottos) {
//            if (existingLotto.equals(lotto)) {
//                return false;
//            }
//        }
//        return true;
//    }


}
