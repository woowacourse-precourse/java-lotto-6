package lotto.Utils;

import java.util.*;

public class Parse{
	public static List<Integer> List_Int(String Number) {
		List<String> Input_Number =Arrays.asList(Number.split(Units.Lotto_Price_Unit.Delimiter()));
		List<Integer> List_Integer= new ArrayList<>();
		for (int i = 0 ; i < Input_Number.size();i++) {
			List_Integer.add(Integer.parseInt(Input_Number.get(i)));
		}		
		return List_Integer;
	}
}