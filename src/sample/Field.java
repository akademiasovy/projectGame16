package sample;

import java.util.Random;

public class Field {

    public Tile[][] getArr() {
        return arr;
    }

    public void setArr(Tile[][] arr) {
        this.arr = arr;
    }

    private Tile[][] arr;


    public Field (){
        initGame();
    }

    private void initGame() {
        arr= new Tile[4][4];
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                arr[i][j]=new Tile();
    }

    public boolean isWinner(){
        int count=0;
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                if(arr[i][j].isValue())
                    count++;

        if(count==0 || count==16) {
            System.out.println("You won!");
            return true;
        }
        else
            return false;
    }

    public void toggleTiles(int code){
        int x=code%4;
        int y=code/4;
        for(int j=0;j<4;j++)
            for(int i=0;i<4;i++)
                if(!(x==i && y==j) && Math.abs(x-i)<=1 && Math.abs(y-j)<=1)
                    arr[i][j].toggle();

    }

    public void shuffle(){
        Random rnd = new Random();
        do {
            for (int i = 0; i < 47; i++)
                toggleTiles(rnd.nextInt(15));
        }while(isWinner());
    }

    public void print() {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++)
                System.out.print(arr[i][j].isValue() ? " X " : " O ");
            System.out.println();
        }
        System.out.println();
    }
}
