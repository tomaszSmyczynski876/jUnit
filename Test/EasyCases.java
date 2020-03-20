import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(Easy.class)
@Categories.ExcludeCategory(Trivial.class)
@Suite.SuiteClasses({CitCalculatorTest.class, TaxCalculatorTest.class})
public class EasyCases {
}
