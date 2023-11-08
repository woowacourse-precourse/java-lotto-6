package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    public void testStringToList() {
        Utils utils = Utils.INSTANCE;

        List<Integer> result = utils.stringToList("5,3,2,1,4,6");
        assertEquals(6, result.size());
        assertEquals(1, result.get(0).intValue());
        assertEquals(6, result.get(5).intValue());

        assertThrows(IllegalArgumentException.class, () -> {
            utils.stringToList("5,3,2,a,4,6");
        });
    }

    @Test
    public void testCountCommonElements() {
        Utils utils = Utils.INSTANCE;

        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);

        int count = utils.countCommonElements(list1, list2);
        assertEquals(3, count);

        list1 = List.of(1, 2, 8);
        list2 = List.of(3, 4, 9);
        count = utils.countCommonElements(list1, list2);
        assertEquals(0, count);
    }

    @Test
    public void testSelectionSort() {
        Utils utils = Utils.INSTANCE;

        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 5, 4));
        utils.selectionSort(list);
        List<Integer> expected = List.of(1, 2, 3, 4, 5);
        assertIterableEquals(expected, list);

        list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        utils.selectionSort(list);
        assertIterableEquals(expected, list);
    }
}