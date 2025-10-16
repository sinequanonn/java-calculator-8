package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberExtractor {

    private static final String DEFAULT_DELIMITER = ",|:|";
    private static final String CUSTOM_DELIMITER_FRONT = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final int FRONT_DELIMITER_LENGTH = CUSTOM_DELIMITER_FRONT.length();
    private static final int END_DELIMITER_LENGTH = CUSTOM_DELIMITER_END.length();

    private static final int MIN_NUMBER = 0;

    public List<Integer> extract(String inputString) {
        String delimiter = DEFAULT_DELIMITER;

        if (inputString.startsWith(CUSTOM_DELIMITER_FRONT)) {
            int endIndex = inputString.indexOf(CUSTOM_DELIMITER_END);
            String customDelimiter = inputString.substring(FRONT_DELIMITER_LENGTH, endIndex);
            delimiter += customDelimiter;
            inputString = inputString.substring(endIndex+END_DELIMITER_LENGTH);
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
        if (parsedNumber < MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
