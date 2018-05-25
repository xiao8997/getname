import com.haoming.service.UserService;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by xiaot on 2018/5/25.
 */
public class BasicTest {
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass-----log:"+System.getProperty("user.home"));
        System.getProperty("user.home");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void test_method_1() {
        UserService us=new UserService();
        assertEquals(us.getUserList().size(),4);
    }

    @Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
    }
}
