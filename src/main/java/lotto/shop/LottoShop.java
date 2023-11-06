package lotto.shop;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.generator.LottoGenerator;
import lotto.validate.Validate;

public class LottoShop {
    private final int LOTTO_PRICE = 1000;
    private Validate validate;
    private LottoGenerator lottoGenerator;

    public LottoShop(LottoGenerator lottoGenerator, Validate validate) {
        this.lottoGenerator = lottoGenerator;
        this.validate = validate;
    }

    public List<Lotto> buyLotto(int money) {
        // 돈이 로또 가격으로 나누어 떨어지는지 검증
        validate.validateDivideNumber(money, LOTTO_PRICE);

        StringBuilder sb = new StringBuilder();

        // 가지고 있는 token 만큼 로또 발행
        int token = money / LOTTO_PRICE;
        System.out.println(token + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < token; i++) {
            // 로또 발행
            lottos.add(lottoGenerator.getLotto());
            lottos.get(i).print();
        }

        return lottos;
    }
}
