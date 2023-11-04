package lotto;

import java.util.List;

public record Customer(Integer buyPrice, List<List<Integer>> lottoNumbers){}
