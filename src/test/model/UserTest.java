package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class UserTest {
    
    private User user1;
    private String transactionID;


    @BeforeEach
    void setUp() {
        user1 = new User("cnay", "abcd", "cnay@gmail.com");

    }




    @Test
    void testGetPassword(){
        String user1pass = user1.getPassword();
        assertEquals("abcd", user1pass);
    }





}