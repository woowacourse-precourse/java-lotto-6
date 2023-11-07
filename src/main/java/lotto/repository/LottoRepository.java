package lotto.repository;

import lotto.template.Callback;
import lotto.template.InputTemplate;
import lotto.valid.Valid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRepository {

    private final InputTemplate inputTemplate = new InputTemplate();
    public int getPrice() {
        String price = inputTemplate.execute("구입금액을 입력해 주세요.", text -> Valid.validPrice(text));
        return Integer.parseInt(price);
    }

    public List<Integer> getWinNum() {
        String winNumStr = inputTemplate.execute("당첨 번호를 입력해 주세요.", text -> Valid.validWinNum(text));
        String[] split = winNumStr.split(",");
        return Arrays.stream(split)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public int getBonusNum(List<Integer> winNum) {
        String bonusNumStr = inputTemplate.execute("보너스 번호를 입력해 주세요.", text -> Valid.distinctCheck(winNum, text));
        return Integer.parseInt(bonusNumStr);
    }

}
