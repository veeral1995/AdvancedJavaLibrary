import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.library.model.business.AllBusinessTests;
import com.library.model.doa.AllDoaTests;
import com.library.model.business.exception.PropertyFileNotFoundException;
import com.library.model.business.manager.ManagerSuperType;
import com.library.model.domain.AllDomainTests;
import com.library.model.services.AllServicesTests;
import com.library.model.services.exception.RetreivalException;
import com.library.model.services.manager.PropertyManager;
import java.io.File;
import java.io.FileInputStream;        
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllServicesTests.class, AllDomainTests.class, AllDoaTests.class})
public class ApplicationTestSuite {

}