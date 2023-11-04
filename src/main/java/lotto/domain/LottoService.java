package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.constant.ErrorConst.PRICE_LESS_THAN_THOUSAND;
import static lotto.domain.constant.ErrorConst.PRICE_NOT_DIVIDED_BY_THOUSAND;

public class LottoService {

    private final List<Lotto> lottoStorage = new ArrayList<>();

    public void buyLottos(int price) {
        validate(price);
        int count = price / 1000;
        for (int i = 0; i < count; i++) {
            buyOneLotto();
        }
    }

    private void buyOneLotto() {
        Lotto lotto = new Lotto(NumberGenerator.generateLottoNumber());
        lottoStorage.add(lotto);
    }

    //TODO: validateMoreThanThousand 등을 인터페이스, 람다식 등을 이용해 변경
    //      그러면 하위 메서드를 계속 정의할 필요가 없을듯
    private static void validate(int price) {
        validateMoreThanThousand(price);
        validateMultipleOfThousand(price);
    }

    private static void validateMultipleOfThousand(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(PRICE_NOT_DIVIDED_BY_THOUSAND);
        }
    }

    private static void validateMoreThanThousand(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(PRICE_LESS_THAN_THOUSAND);
        }
    }

}
