/**
 * @Package_name : utility
 * @Class_name : Utility
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package utility;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utility {

    /**
     * Description : camp.nextstep.edu.missionutils.Console에서 제공하는 Console API 사용
     *
     * @Method : campReadline()
     * @return : String
     */
    public static String campReadline() {
        return Console.readLine();
    }

    /**
     * Description : camp.nextstep.edu.missionutils.Randoms에서 제공하는 pickUniqueNumbersInRange API 사용
     *
     * @Method : campPickUniqueNumbersInRange()
     * @return : List<Integer>
     */
    public static List<Integer> campPickUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}