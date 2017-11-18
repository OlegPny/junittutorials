import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

//cpecifying runner
@RunWith(value = org.junit.runners.Suite.class)
//with these test-cases to run
@Suite.SuiteClasses(value = {CalculatorTest.class, ParameterizedCalculatorTest.class})
public class SuitWithDifCases {
}
