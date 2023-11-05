package lottovender;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoVender {
    private final int LOTTO_PRICE = 1000;
    public int payPrice(String inputPrice){
        int buyLottoCount;
        validate(inputPrice);
        buyLottoCount = Integer.parseInt(inputPrice) / LOTTO_PRICE;
        return buyLottoCount;
    }

    private void validate(String inputPrice) {
        int price;

        // 공백 입력한 경우 예외 처리
        if (inputPrice.trim()=="") throw new IllegalArgumentException();

        // 숫자가 아닐경우 예외 처리
        try{
            price = Integer.parseInt(inputPrice.replace(",",""));
        }catch(Exception e){
            throw new IllegalArgumentException();
        }

        //천원 단위로 나누어떨어지지않는 경우 예외 처리
        if (price % 1000 != 0) throw new IllegalArgumentException();
    }

    public List<Lotto> getLotto(int buyLottoCount){
        List<Lotto> lottoticekts = new ArrayList<>();
        for(int i = 0; i<buyLottoCount; i++){
            //6개의 랜덤 로또 번호 생성해주는 numbers
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoticekts.add(new Lotto(numbers));
        }
        return lottoticekts;
    }
}
