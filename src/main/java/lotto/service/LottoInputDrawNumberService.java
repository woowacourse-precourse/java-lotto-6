package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.repository.Lotto;
import lotto.enums.LottoRule;
import lotto.enums.UserInterfaceMessage;

public class LottoInputDrawNumberService {
    private List<Lotto> DrawLottoNumber = new ArrayList<>();
    private Lotto lottoDrawNumber;

    private LottoInputDrawNumberService() {
    }

    private static class LottoInputDrawNumberServiceHoler {
        private static final LottoInputDrawNumberService LOTTO_INPUT_DRAW_NUMBER_SERVICE = new LottoInputDrawNumberService();
    }

    public static LottoInputDrawNumberService getInstance() {
        return LottoInputDrawNumberServiceHoler.LOTTO_INPUT_DRAW_NUMBER_SERVICE;
    }

    public void saveDrawNumber(String lottoNumber) {
        validate(lottoNumber);
        validateInputNumberCount(lottoNumber);
        List<Integer> drawNumber = String2IntegerList(lottoNumber);
        lottoDrawNumber = new Lotto(drawNumber);
    }

    private List<Integer> String2IntegerList(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.replace(" ", "").strip().split(",");
        List<Integer> lottoDrawNumber =
                Arrays.stream(lottoNumbers).map(individualNumber -> Integer.parseInt(individualNumber))
                        .collect(Collectors.toList());
        Collections.sort(lottoDrawNumber);
        return lottoDrawNumber;
    }

    private void validate(String lottoNumber) {
        try {
            String lottoDrawNumber = lottoNumber.replace(",", "").replace(" ","").strip();
            Integer.parseInt(lottoDrawNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_NUMBER_INCLUSIVE.getValue(),
                    LottoRule.START.getValue(), LottoRule.END.getValue()));
        }
    }
    private void validateInputNumberCount(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.replace(" ", "").strip().split(",");
        if (Arrays.stream(lottoNumbers).count() != LottoRule.LOTTO_MAX_COUNT.getValue()) {
            throw new IllegalArgumentException(UserInterfaceMessage.ERROR_PREFIX.getValue()
                    + String.format(UserInterfaceMessage.REQUEST_INPUT_PRICE_INFO.getValue(),
                    LottoRule.START.getValue(), LottoRule.END.getValue()));
        }
    }

    public List<Integer> getLottoDrawNumber() {
        return lottoDrawNumber.getNumbers();
    }

}
