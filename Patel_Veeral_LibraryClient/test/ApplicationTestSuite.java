import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.library.model.domain.AllDomainTests;
import java.io.File;
import java.io.FileInputStream;        
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Suite.class)
@SuiteClasses({AllDomainTests.class})
public class ApplicationTestSuite {

}