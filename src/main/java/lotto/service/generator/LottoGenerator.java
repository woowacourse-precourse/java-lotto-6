package lotto.service.generator;

import java.util.List;
import lotto.domain.LottoBall;

public interface LottoGenerator {
    List<LottoBall> generate();
}
