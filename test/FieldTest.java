import org.junit.jupiter.api.Test;
import sample.Field;
import sample.Tile;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    private Field field;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        field = new Field();


    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void isWinner() {
       assertTrue(field.isWinner());
       field.getArr()[1][1].setValue(true);
       assertFalse(field.isWinner());
        for(int j=0;j<4;j++)
            for(int i=0;i<4;i++)
                field.getArr()[i][j].setValue(true);
        assertTrue(field.isWinner());
        field.getArr()[3][2].setValue(false);
        assertFalse(field.isWinner());
    }

    @Test
    void test1(){
        field.toggleTiles(0);
        assertFalse(field.getArr()[0][0].isValue());
        assertTrue(field.getArr()[1][0].isValue());
        assertTrue(field.getArr()[1][1].isValue());
        assertTrue(field.getArr()[0][1].isValue());
    }

    @Test
    void test2(){
        field.toggleTiles(2);
        assertFalse(field.getArr()[2][0].isValue());
        assertTrue(field.getArr()[1][0].isValue());
        assertTrue(field.getArr()[3][0].isValue());
        assertTrue(field.getArr()[1][1].isValue());
        assertTrue(field.getArr()[2][1].isValue());
        assertTrue(field.getArr()[3][1].isValue());
    }

    @Test
    void test3(){
        field.toggleTiles(6);
        assertFalse(field.getArr()[2][1].isValue());
        assertTrue(field.getArr()[1][0].isValue());
        assertTrue(field.getArr()[2][0].isValue());
        assertTrue(field.getArr()[3][0].isValue());
        assertTrue(field.getArr()[1][1].isValue());
        assertTrue(field.getArr()[3][1].isValue());
        assertTrue(field.getArr()[1][2].isValue());
        assertTrue(field.getArr()[2][2].isValue());
        assertTrue(field.getArr()[3][2].isValue());
    }

    @Test
    void test4(){
        field.toggleTiles(13);
        field.toggleTiles(7);
        field.toggleTiles(5);
        field.toggleTiles(2);
        field.toggleTiles(2);
        field.toggleTiles(5);
        field.toggleTiles(7);
        field.toggleTiles(13);

        field.toggleTiles(13);

        assertFalse(field.getArr()[1][3].isValue());
        assertTrue(field.getArr()[0][3].isValue());
        assertTrue(field.getArr()[2][3].isValue());
        assertTrue(field.getArr()[0][2].isValue());
        assertTrue(field.getArr()[1][2].isValue());
        assertTrue(field.getArr()[2][2].isValue());

        field.toggleTiles(13);
        assertTrue(field.isWinner());
    }
}