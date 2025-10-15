package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberExtractorTest {

    NumberExtractor numberExtractor;

    @BeforeEach
    void setUp() {
        numberExtractor = new NumberExtractor();
    }

    @Test
    void 기본_구분자가_포함된_문자열로부터_양수_리스트_반환() {
        List<Integer> numbers = numberExtractor.extract("1:2,3");

        assertThat(numbers).containsExactly(1,2,3);
    }

    @Test
    void 커스텀_구분자가_포함된_문자열로부터_양수_리스트_반환() {
        List<Integer> numbers = numberExtractor.extract("//;\\n1;2,3");

        assertThat(numbers).containsExactly(1,2,3);
    }

    @Test
    void 빈_문자열로부터_빈_리스트_반환() {
        List<Integer> numbers = numberExtractor.extract("");

        assertThat(numbers).isEmpty();
    }

    @Test
    void 음수가_포함된_문자열_예외처리_테스트() {
        assertThatThrownBy(() -> numberExtractor.extract("-1:2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
