package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberExtractor {

    public List<Integer> extract(String inputString) {
        String delimiter = ",|:";

        if (inputString.startsWith("//")) {
            int endIndex = inputString.indexOf('\n');
            String customDelimiter = inputString.substring(2, endIndex);
            delimiter += "|" + customDelimiter;
            inputString = inputString.substring(endIndex+1);
        }

        return Arrays.stream(inputString.split(delimiter))
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
