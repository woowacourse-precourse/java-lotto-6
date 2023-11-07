package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> createNewRandomNumber() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        mergeSort(randomNumber);
        return randomNumber;
    }

    private List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        Divide dividedList = getLeftAndRight(list);
        return merge(mergeSort(dividedList.left()), mergeSort(dividedList.right()));
    }

    private Divide getLeftAndRight(List<Integer> list) {
        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));
        Divide divideList = new Divide(left, right);
        return divideList;
    }

    private record Divide(List<Integer> left, List<Integer> right) {
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                merged.add(left.get(leftIndex++));
                continue;
            }
            merged.add(right.get(rightIndex++));
        }

        addRemainingValues(left, merged, leftIndex);
        addRemainingValues(right, merged, rightIndex);

        return merged;
    }

    private void addRemainingValues(List<Integer> leftOrRight, List<Integer> merged, int index) {
        while (index < leftOrRight.size()) {
            merged.add(leftOrRight.get(index++));
        }
    }
}
