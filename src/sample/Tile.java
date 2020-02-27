package sample;

public class Tile {

    private boolean value;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void toggle(){
        value=!value;
    }

    public Tile(){
        value=false;
    }
}
