package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchedNumberTest {
    @Test
    @DisplayName("맞춘 번호 갯수 반환 검증")
    public void 맞춘_번호_개수_반환(){
        ArrayList<List<String>> myLottos = new ArrayList<>();
        List<String> myLotto1 = List.of("1","2","3","4","5","6");
        List<String> myLotto2 = List.of("1","2","3","4","6","7");
        List<String> myLotto3 = List.of("1","2","3","6","7","8");
        myLottos.add(myLotto1);
        myLottos.add(myLotto2);
        myLottos.add(myLotto3);
        ArrayList<String> winLotto = new ArrayList<String>(Arrays.asList("6","7","8","9","10","11"));

        MatchedNumbers matchedNumbers = new MatchedNumbers(myLottos,winLotto);

        ArrayList<String> myResult = matchedNumbers.getLOTTO_MATCHED_COUNT_LIST();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1","2","3"));
        assertEquals(myResult,expected);
    }

}
