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
        List<Double> numbers = positiveNumberExtractor.extract("1:2,3");

        assertThat(numbers).containsExactly(1.0,2.0,3.0);
    }

    @Test
    void 커스텀_구분자가_포함된_문자열로부터_양수_리스트_반환() {
        List<Double> numbers = positiveNumberExtractor.extract("//;\\n1;2,3");

        assertThat(numbers).containsExactly(1.0,2.0,3.0);
    }

    @Test
    void 빈_문자열로부터_빈_리스트_반환() {
        List<Double> numbers = positiveNumberExtractor.extract("");

        assertThat(numbers).isEmpty();
    }

    @Test
    void 음수가_포함된_문자열_예외처리_테스트() {
        assertThatThrownBy(() -> positiveNumberExtractor.extract("-1:2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실수가_포함된_문자열로부터_리스트_추출하기() {
        List<Double> numbers = positiveNumberExtractor.extract("1.3,2:3");

        assertThat(numbers).containsExactly(1.3, 2.0, 3.0);
    }

    @Test
    void 기본_구분자와_커스텀_구분자_양수_이외의_문자가_포함된_경우_예외처리() {
        assertThatThrownBy(() -> positiveNumberExtractor.extract("mkmdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자가_공백인_경우_예외처리() {
        assertThatThrownBy(() -> positiveNumberExtractor.extract("//\\n"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
