import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private final List<List<Element>> matrix = new ArrayList<>();
    private final int width;
    private final int height;

    Matrix(int width, int height, Character defaultChar) {
        this.width = width;
        this.height = height;

        for (int i = 0; i < height; i++) {
            List<Element> aux = new ArrayList<>();
            for (int j = 0; j < width; j++)
                aux.add(new EmptyElement(i, j, defaultChar, "#000000"));
            matrix.add(aux);
        }
    }

    public boolean setPos(Element c) {
        if (c == null) return false;
        int x = c.getPosition().getX();
        int y = c.getPosition().getY();

        if (x < 0 || y < 0 || x >= width || y >= height) return false;

        matrix.get(y).set(x, c);
        return true;
    }

    public Element getPos(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return null;
        return matrix.get(y).get(x);
    }

    public Element getPos(Position pos) {
        if (pos.getX() < 0 || pos.getY() < 0 || pos.getX() >= width || pos.getY() >= height) return null;
        return matrix.get(pos.getY()).get(pos.getX());
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(matrix.get(i).get(j).getChar());
            System.out.println();
        }
    }


}