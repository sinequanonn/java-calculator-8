package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberExtractorTest {

    PositiveNumberExtractor positiveNumberExtractor;

    @BeforeEach
    void setUp() {
        positiveNumberExtractor = new PositiveNumberExtractor();
    }

    @Test
    void 기본_구분자가_포함된_문자열로부터_양수_리스트_반환() {
        List<Integer> numbers = positiveNumberExtractor.extract("1:2,3");

        assertThat(numbers).containsExactly(1,2,3);
    }

    @Test
    void 커스텀_구분자가_포함된_문자열로부터_양수_리스트_반환() {
        List<Integer> numbers = positiveNumberExtractor.extract("//;\\n1;2,3");

        assertThat(numbers).containsExactly(1,2,3);
    }

    @Test
    void 빈_문자열로부터_빈_리스트_반환() {
        List<Integer> numbers = positiveNumberExtractor.extract("");

        assertThat(numbers).isEmpty();
    }

    @Test
    void 음수가_포함된_문자열_예외처리_테스트() {
        assertThatThrownBy(() -> positiveNumberExtractor.extract("-1:2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
