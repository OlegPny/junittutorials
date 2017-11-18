import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestDefaultController {

    private DefaultController controller;
    private RequestHandler handler;
    private Request request;

    //@Before - method is executed just before every of @Test
    //@BeforeClass - method is executed only once before all @Test
    @Before
    public void instantinate() throws Exception {
        controller = new DefaultController();
        handler = new SampleHandler();
        request = new SampleRequest();
        controller.addHandler(request, handler);
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

        private static final String NAME = "Test";

        @Override
        public boolean equals(Object o) {
            boolean result = false;
            if (o instanceof SampleResponse) {
                result = (((SampleResponse) o).getName().equals(this.getName()));
            }
            return result;
        }

        @Override
        public int hashCode() {
            return NAME.hashCode();
        }
        
        public String getName() {
            return NAME;
        }
    }

    @Test
    public void testAddHandler() {
        RequestHandler handler2 = controller.getHandler(request);
        assertSame("Handler we set in controller should be the same handler we get",
                handler, handler2);
    }

    @Test
    public void testProcessRequest() {
        Response response = controller.processRequest(request);
        assertNotNull("Must not return null", response);
        assertEquals("Response must be of type SampleResponse", SampleResponse.class, response.getClass());
    }

}
