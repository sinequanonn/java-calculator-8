package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberExtractor {

    public List<Integer> extract(String inputString) {
        String delimiter = ",|:";

        if (inputString.startsWith("//")) {
            int endIndex = inputString.indexOf("\\n");
            String customDelimiter = inputString.substring(2, endIndex);
            delimiter += "|" + customDelimiter;
            inputString = inputString.substring(endIndex+2);
        }

        return Arrays.stream(inputString.split(delimiter))
                .filter(number -> !number.isEmpty())
                .map(this::parseToInteger)
                .collect(Collectors.toList());
    }

    private Integer parseToInteger(String number) {
        try {
            Integer parsedNumber = Integer.parseInt(number);
            validate(parsedNumber);
            return parsedNumber;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(Integer parsedNumber) {
        if (parsedNumber < 0) {
            throw new IllegalArgumentException();
        }
    }

}
