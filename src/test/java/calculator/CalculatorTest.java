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
        List<Double> numbers = Arrays.asList(1.0,2.0,3.0,4.0,5.0);

        Assertions.assertThat(calculator.sum(numbers)).isEqualTo(15);
    }

    @Test
    void 양수가_없는_빈_리스트인_경우_0_반환_테스트() {
        List<Double> numbers = List.of();

        Assertions.assertThat(calculator.sum(numbers)).isEqualTo(0);
    }
}
