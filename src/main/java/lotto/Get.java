package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Get {
    public static int purchaseNumber(){ return Integer.parseInt(readLine()); }
    public static String[] winningNumber(){ return readLine().split(","); }
    public static int bonusNumber(){ return Integer.parseInt(readLine()); }

}
