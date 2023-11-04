package lotto.domain;

public class Seller {

    // 2. 로또 수량 계산 로직
    public static Integer calculateLottoCount(Integer money) {
        Integer lottoCount = money / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }
}
