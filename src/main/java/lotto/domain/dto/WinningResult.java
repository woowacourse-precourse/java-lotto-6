package lotto.domain.dto;

import java.util.LinkedHashMap;
import lotto.constant.Prize;

public record WinningResult(LinkedHashMap<Prize, Integer> prizes) {
}
