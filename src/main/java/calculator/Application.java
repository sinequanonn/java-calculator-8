package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        NumberExtractor numberExtractor = new NumberExtractor();
        Calculator calculator = new Calculator();

        String inputString = inputView.input();
        List<Integer> numbers = numberExtractor.extract(inputString);
        Integer sum = calculator.sum(numbers);
        outputView.printResult(sum);
    }
}
