package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Utils {
    INSTANCE;
    public List<Integer> stringToList(String input) {
        String[] split = input.split(",");
        List<Integer> integerList = new ArrayList<>();
        for (String item : split) {
            try {
                int num = Integer.parseInt(item);
                integerList.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력된 로또 번호가 숫자가 아닙니다.");
            }
        }
        Collections.sort(integerList);
        return integerList;
    }

    public Integer countCommonElements(List<?> list1, List<?> list2) {
        Integer count = 0;
        for (Object element : list1) {
            if (list2.contains(element)) {
                count++;
            }
        }
        return count;
    }

    public void selectionSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}
