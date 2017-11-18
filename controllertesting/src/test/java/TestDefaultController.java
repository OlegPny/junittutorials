import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestDefaultController {

    private DefaultController controller;

    //@Before - method is executed just before every of @Test
    //@BeforeClass - method is executed only once before all @Test
    @Before
    public void instantinate() throws Exception {
        controller = new DefaultController();
    }

    @Test
    public void testMethod() {
        //throw new RuntimeException("implement me");
    }

    @Test
    public void testAddHandler() {
        Request request = new SampleRequest();
        RequestHandler handler = new SampleHandler();
        controller.addHandler(request, handler);
        RequestHandler handler2 = controller.getHandler(request);
        assertSame("Handler we set in controller should be the same handler we get",
                handler, handler2);
    }

    @Test
    public void testProcessRequest() {
        Request request = new SampleRequest();
        RequestHandler handler = new SampleHandler();
        controller.addHandler(request, handler);
        Response response = controller.processRequest(request);
        assertNotNull("Must not return null", response);
        assertEquals("Response must be of type SampleResponse", SampleResponse.class, response.getClass());
    }


    //Classes to use in test (pre-test state or "test fixture")
    private class SampleRequest implements Request {

        public String getName() {
            return "Test";
        }
    }

    private class SampleHandler implements RequestHandler {

        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {

    }
}
