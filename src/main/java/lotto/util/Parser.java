package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static int stringToInt(String str) throws IllegalArgumentException{
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수가 아닌 입력이 들어왔습니다.");
        }
    }

    public static List<Integer> stringToList(String str) throws IllegalArgumentException {
        try {
            return Stream.of(str.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 번호 중 정수가 아닌 것이 있습니다.");
        }
    }
}
