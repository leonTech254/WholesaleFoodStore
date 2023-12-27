//import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;
//import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.CustomerRepository;
//import com.leonteqsecurity.WholesaleFoodStore.Service.CustomerServices;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class CustomerServicesTest {
//
//    @Mock
//    private CustomerRepository customerRepository;
//
//    @InjectMocks
//    private CustomerServices customerServices;
//
//    @Test
//    void testFindAllCustomers() {
//        // Mocking the repository to return a list of customers
//        List<Customer> mockCustomers = new ArrayList<>();
//        when(customerRepository.findAllCustomers()).thenReturn(mockCustomers);
//
//        // Testing the service method
//        List<Customer> result = customerServices.findAllCustomers();
//
//        assertNotNull(result);
//        assertEquals(mockCustomers, result);
//    }
//
//    @Test
//    void testFindCustomer() {
//        // Mocking the repository to return a customer
//        int customerId = 1;
//        Customer mockCustomer = new Customer();
//        when(customerRepository.findCustomer(customerId)).thenReturn(mockCustomer);
//
//        // Testing the service method
//        Customer result = customerServices.findCustomer(customerId);
//
//        assertNotNull(result);
//        assertEquals(mockCustomer, result);
//    }
//
//    @Test
//    void testDeleteCustomer() {
//        // Mocking the repository to return true when deleting a customer
//        int customerId = 1;
//        when(customerRepository.deleteCustomer(customerId)).thenReturn(true);
//
//        // Testing the service method
//        boolean result = customerServices.deleteCustomer(customerId);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void testUpdateCustomer() {
//        // Mocking the repository to return true when updating a customer
//        Customer customer = new Customer();
//        when(customerRepository.updateCustomer(
//                Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
//                Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
//                Mockito.anyString(), Mockito.anyInt())
//        ).thenReturn(true);
//
//        // Testing the service method
//        boolean result = customerServices.updateCustomer(customer);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void testAddCustomer() {
//        // Mocking the repository to do nothing when adding a customer
//        Customer customer = new Customer();
//        Mockito.doNothing().when(customerRepository).addCustomer(
//                Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
//                Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
//                Mockito.anyString()
//        );
//
//        // Testing the service method
//        boolean result = customerServices.addCustomer(customer);
//
//        assertTrue(result);
//    }
//}
