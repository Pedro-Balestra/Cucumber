package converters;

import io.cucumber.java.ParameterType;

public class CustomParameterTypes {
    @ParameterType("R\\$ ([0-9]+)")
    public Integer priceParam(String str) {
        return Integer.parseInt(str);
    }
}
