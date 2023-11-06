package lotto.service.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@DisplayName("랜덤을 입맛대로 가공하는 서비스 로직")
public class CreateRandomNumber {
    private static List<Integer> autoUniqueNumbers;
    private static int missNumber;
    public static List<Integer> getAutoUniqueNumbers(int pickNumber) {
        autoUniqueNumbers
          = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,pickNumber));
        Collections.sort(autoUniqueNumbers);
        return autoUniqueNumbers;
    }
    public static int getBonusNumber(){
        do{
           missNumber = Randoms.pickNumberInRange(1,45);
        }while (autoUniqueNumbers.contains(missNumber));
        return missNumber;
    }
}
