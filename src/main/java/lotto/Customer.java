package lotto;

import java.util.List;
import java.util.Map;

public record Customer(Integer buyPrice, Map<Integer, List<Integer>> lottoNumbers) {

}
