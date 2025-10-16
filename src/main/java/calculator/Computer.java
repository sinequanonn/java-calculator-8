package calculator;

import java.util.List;

public class Computer {

    private InputView inputView;
    private OutputView outputView;
    private PositiveNumberExtractor positiveNumberExtractor;
    private Calculator calculator;

    public Computer() {
        inputView = new InputView();
        outputView = new OutputView();
        positiveNumberExtractor = new PositiveNumberExtractor();
        calculator = new Calculator();
    }

    public void execute() {
        String inputString = inputView.input();
        List<Integer> numbers = positiveNumberExtractor.extract(inputString);
        Integer sum = calculator.sum(numbers);
        outputView.printResult(sum);
    }
}
