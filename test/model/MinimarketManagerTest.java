package model;

import exceptions.InvalidDayException;
import exceptions.UnderAgeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimarketManagerTest {

    private MinimarketManager manager;

    private void setupScenary1(){
        manager = new MinimarketManager();
    }

    @Test
    public void test1(){
        setupScenary1();

        String type = "CC";
        String id = "1007983286";
        int day = 9;

        try{
            assertTrue(manager.registerClient(type, id, day));
        } catch(UnderAgeException e){
            fail();
        } catch (InvalidDayException e){
            fail();
        }
    }

    @Test
    public void test2(){
        setupScenary1();

        String type = "TI";
        String id = "1007983286";
        int day = 9;

        try{
            assertFalse(manager.registerClient(type, id, day));
        } catch(UnderAgeException e){
            e.printStackTrace();
        } catch(InvalidDayException e){
            fail();
        }
    }

    @Test
    public void test3(){
        setupScenary1();

        String type = "CC";
        String id = "1007983286";
        int day = 10;

        try{
            assertFalse(manager.registerClient(type, id, day));
        } catch(UnderAgeException e){
            fail();
        } catch(InvalidDayException e){
            e.printStackTrace();
        }
    }
}