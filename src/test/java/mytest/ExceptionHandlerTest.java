package mytest;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions. *;
public class ExceptionHandlerTest {

//    @Test
////    public void shouldHandleIllegalArgumentException() {
////        String expectedMessage = "Invalid argument";
////        Callable<String> method = () -> {
////            throw new IllegalArgumentException(expectedMessage);
////        };
////
////        String actualMessage = ExceptionHandlerCopy.handleException(method);
////        assertThat(actualMessage).isEqualTo(expectedMessage);
////    }
////
////    @Test
////    public void shouldHandleGeneralException() {
////        String expectedMessage = "General exception";
////        Callable<String> method = () -> {
////            throw new Exception(expectedMessage);
////        };
////
////        String actualMessage = ExceptionHandlerCopy.handleException(method);
////        assertThat(actualMessage).isEqualTo(expectedMessage);
////    }
////
////    @Test
////    public void shouldThrowNoSuchElementException() {
////        String expectedMessage = "No such element";
////        Callable<String> method = () -> {
////            throw new NoSuchElementException(expectedMessage);
////        };
////
////        assertThatThrownBy(() -> ExceptionHandlerCopy.handleException(method))
////                .isInstanceOf(NoSuchElementException.class)
////                .hasMessage(expectedMessage);
////    }
}
