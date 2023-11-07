package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.repository.Lotto;
import lotto.enums.LottoRule;
import lotto.enums.UserInterfaceMessage;

public class LottoPublishService {
    private List<Lotto> publishedLottoNumbers = new ArrayList<>();

    public Integer getLottoPrice() {
        return lottoPrice;
    }

    private Integer lottoPrice;
    private Integer boughtLottoCount;

    private LottoPublishService() {
    }


    private static class LottoPublishServiceHolder {
        final static LottoPublishService LOTTO_PUBLISH_SERVICE = new LottoPublishService();
    }

    public static LottoPublishService getInstance() {
        return LottoPublishServiceHolder.LOTTO_PUBLISH_SERVICE;
    }

    // 상태 초기화
    public void clearPublishedLottoNumbers() {
        publishedLottoNumbers = new ArrayList<>();
    }

    public void lottoPublish(String price) {
        lottoPrice = String2Integer(price);
        boughtLottoCount(lottoPrice);
        for (int i = 1; i <= boughtLottoCount; i++) {
            createLottoNumber();
        }
    }

    private void createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoRule.START.getValue(),
                LottoRule.END.getValue(),
                LottoRule.LOTTO_MAX_COUNT.getValue());
        publishedLottoNumbers.add(new Lotto(numbers));
    }

    public List<Lotto> getPublishedLottoNumbers() {
        return publishedLottoNumbers;
    }

    private Integer String2Integer(String numberformat) {
        Integer price = 0;
        try {
            price = Integer.parseInt(numberformat);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_INCLUSIVE.getValue(),
                    LottoRule.START.getValue(), LottoRule.END.getValue()));
        }
        return price;
    }

    private void boughtLottoCount(Integer lottoPrice) {
        boughtLottoCount = lottoPrice / LottoRule.LOTTO_PRICE.getValue();
    }
}
