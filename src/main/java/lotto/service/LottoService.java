package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.constant.Message;

public class LottoService {

    public List<Integer> parseInputToNumberCandidates(String input) throws NumberFormatException{
        return Arrays.stream(input.split(Message.COMMA))
                .map(String::trim)
                .map(Integer::parseUnsignedInt)
                .toList();
    }

}
