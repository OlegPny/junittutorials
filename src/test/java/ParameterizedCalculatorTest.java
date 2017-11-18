import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

//use parameterized test-runner
@RunWith(value = Parameterized.class)
public class ParameterizedCalculatorTest {

    private double expected;
    private double valueOne;
    private double valueTwo;

    //must be public, static and return a Collection instance
    @Parameters
    public static Collection dataParameters() {
        return Arrays.asList(new Object[][] {
                {2,1,1},  //expected, valueOne, valueTwo
                {3,2,1},
                {4,3,1},
        });
    }

    //obligatory constructor for test
    public ParameterizedCalculatorTest(double expected,
                             double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum() {
        Calculator calc = new Calculator();
        assertEquals(expected, calc.add(valueOne, valueTwo),0);
    }
}
