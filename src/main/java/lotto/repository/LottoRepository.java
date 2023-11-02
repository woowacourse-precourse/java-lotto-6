package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.WinNum;
import lotto.enums.LottoEnum;
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

        return Arrays.stream(winNumStr.split(","))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public int getBonusNum() {
        String bonusNumStr = inputTemplate.execute("보너스 번호를 입력해 주세요.", text -> Valid.validBonusNum(text));
        return Integer.parseInt(bonusNumStr);
    }

    public void distinctCheck(List<Integer> winNum, int bonusNum) {
        Valid.distinctCheck(winNum, bonusNum);
    }

    public LottoEnum countResult(Lotto lotto, WinNum winNum) {
        return winNum.countResult(lotto);
    }
}
