package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottosResponse {
    private List<List<Integer>> lottos;

    public LottosResponse(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

}
