package tool;

import java.util.ArrayList;
import java.util.List;
import lotto.Const;
import validation.IntegerValidator;
import validation.StringValidator;

public class Convert {
  public static List<Integer> stringToIntList(String str, String regex) {
    List<Integer> resultList = new ArrayList<>();

    for (String s : str.split(regex)) {
      int number = StringValidator.checkIntegerType(s);

      resultList.add(number);
    }

    return resultList;
  }
}
