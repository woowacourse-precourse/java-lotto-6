package tool;

import java.util.ArrayList;
import java.util.List;
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

  public static String intListToString(List<Integer> list, String regex) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i : list) {
      sb.append(i + regex);
    }
    sb.deleteCharAt(sb.lastIndexOf(regex));
    sb.append("]");

    return sb.toString();
  }
}
