package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 양수_합_계산_테스트() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        Assertions.assertThat(calculator.sum(numbers)).isEqualTo(15);
    }

    @Test
    void 양수가_없는_빈_리스트인_경우_0_반환_테스트() {
        List<Integer> numbers = List.of();

        Assertions.assertThat(calculator.sum(numbers)).isEqualTo(0);
    }
}
