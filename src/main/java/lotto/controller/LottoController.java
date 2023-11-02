package lotto.controller;


import lotto.dto.NumbersDto;
import lotto.dto.WinningNumberDto;
import lotto.service.LottoService;

import java.util.ArrayList;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public WinningNumberDto post1stNumber(String input) throws Exception {
        return lottoService.postNormalNumbers(convert2Dto(input));
    }

    private NumbersDto convert2Dto(String str) {
        String[] arr = str.split(",");
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (String s : arr) {
            // NumberFormatException 발생 우려
            result.add(Integer.parseInt(s.trim()));
        }

        result.sort(null);
        return new NumbersDto(result);
    }
}
