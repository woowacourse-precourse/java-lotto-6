import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmutableTest {
    @Test
    public void final도_값_변경이_가능하다() {
        //given
        final Map<String, Boolean> collection = new HashMap<>();
        //when
        collection.put("1", true);
        collection.put("2", true);
        collection.put("3", true);
        collection.put("4", true);
        //then
        Assertions.assertThat(collection.size()).isEqualTo(4);
    }
}
