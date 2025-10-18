package calculator;

import java.util.List;

public class Calculator {

    public Double sum(List<Double> numbers) {

        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
