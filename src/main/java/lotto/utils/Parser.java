package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    //추후에 stream으로 변경 가능
    public List<String> parseInputNumber(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    //일단 만들어놨는데 아마 보너스 숫자는 기존 array에 추가하는 형식
    public int parseBonusNumber(String input) {
        return Integer.parseInt(input);
    }

}
